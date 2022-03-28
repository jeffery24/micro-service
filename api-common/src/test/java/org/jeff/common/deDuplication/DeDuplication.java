package org.jeff.common.deDuplication;

import lombok.extern.slf4j.Slf4j;
import org.jeff.util.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import javax.annotation.Resource;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author jeff
 * @since 1.0.0
 */
@Slf4j
@SpringBootTest
public class DeDuplication {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void deDuplication() {
        //两个请求一样，但是请求时间差一秒
        //防止重复提交需要剔除时间、GPS、经纬度等字段
        String req = "{\n" +
                "\"requestTime\" :\"20190101120001\",\n" +
                "\"requestValue\" :\"1000\",\n" +
                "\"requestKey\" :\"key\"\n" +
                "}";

        String req2 = "{\n" +
                "\"requestTime\" :\"20190101120002\",\n" +
                "\"requestValue\" :\"1000\",\n" +
                "\"requestKey\" :\"key\"\n" +
                "}";


        //全参数比对，所以两个参数MD5不同
        String dedupMD50 = dedupParamMD5(req);
        String dedupMD51 = dedupParamMD5(req2);
        System.out.println("req1MD5 = " + dedupMD50 + " , req2MD5=" + dedupMD51);

        String dedupMD5 = dedupParamMD5(req, "requestTime");
        String dedupMD52 = dedupParamMD5(req2, "requestTime");
        System.out.println("req1MD5 = " + dedupMD5 + " , req2MD5=" + dedupMD52);


        // 完整去重方案
        String userId = "12345678";//用户
        String method = "pay";//接口名
        String deduplicationMD5 = dedupParamMD5(req, "requestTime");//计算请求参数摘要，其中剔除里面请求时间的干扰
        String KEY = "dedup:U=" + userId + "M=" + method + "P=" + dedupMD5;

        long expireTime = 1000;// 1000毫秒过期，1000ms内的重复请求会认为重复
        long expireAt = System.currentTimeMillis() + expireTime;
        String val = "expireAt@" + expireAt;

        // NOTE:直接SETNX不支持带过期时间，所以设置+过期不是原子操作，极端情况下可能设置了就不过期了，
        // 后面相同请求可能会误以为需要去重，所以这里使用底层API，保证SETNX+过期时间是原子操作
        Boolean firstSet = stringRedisTemplate.execute(
                (RedisCallback<Boolean>) connection -> connection.set(KEY.getBytes(), val.getBytes(),
                        Expiration.milliseconds(expireTime),
                RedisStringCommands.SetOption.SET_IF_ABSENT));

        final boolean isConsiderDup;
        if (firstSet != null && firstSet) {
            isConsiderDup = false;
        } else {
            isConsiderDup = true;
        }


    }

    public static String dedupParamMD5(final String reqParam, String... excludeKeys) {

        TreeMap paramTreeMap = JsonUtils.jsonToPojo(reqParam, TreeMap.class);
        // 排除所有时间、GPS等每次微小变换的参数

        if (excludeKeys != null && paramTreeMap != null) {
            List<String> dedupExcludeKeys = Arrays.asList(excludeKeys);
            if (!dedupExcludeKeys.isEmpty()) {
                dedupExcludeKeys.forEach(paramTreeMap::remove);
            }
        }

        // reqParam convert json
        String paramTreeMapJSON = JsonUtils.objectToJson(paramTreeMap);
        String md5deDupParam = jdkMD5(paramTreeMapJSON);
        log.debug("md5deDupParam = {}, excludeKeys = {} {}", md5deDupParam, Arrays.deepToString(excludeKeys),
                paramTreeMapJSON);

        return md5deDupParam;
    }

    private static String jdkMD5(String src) {
        String res = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] mdBytes = messageDigest.digest(src.getBytes());
            res = DatatypeConverter.printHexBinary(mdBytes);
        } catch (Exception e) {
            log.error("", e);
        }
        return res;
    }

}
