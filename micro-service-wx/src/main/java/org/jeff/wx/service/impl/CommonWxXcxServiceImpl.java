package org.jeff.wx.service.impl;


import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.jeff.wx.domain.dto.WxParameterDTO;
import org.jeff.wx.domain.dto.XcxLoginDTO;
import org.jeff.wx.service.CommonWxXcxService;
import org.springframework.stereotype.Service;

/**
 * @author jeff
 * @since 1.0.0
 */
@Slf4j
@Service
public class CommonWxXcxServiceImpl implements CommonWxXcxService {

    public static final String WX_BASE_URL = "https://api.weixin.qq.com";

    @Override
    public Object getAccessToken(WxParameterDTO wxParameterDTO) {

        String appId = wxParameterDTO.getAppId();
        StringBuilder getAccessTokenUrl = new StringBuilder(WX_BASE_URL)
                .append("/cgi-bin/token?grant_type=client_credential&appid=")
                .append(appId)
                .append("&secret=")
                .append(wxParameterDTO.getSecret());
        String resp = HttpUtil.get(String.valueOf(getAccessTokenUrl));
        log.info("xcx get access token appid:{}  resp:{}", appId, resp);
        return resp;
    }

    @Override
    public Object XcxLogin(XcxLoginDTO loginDTO) {
        StringBuilder jsCode2sessionUrl = new StringBuilder(WX_BASE_URL)
                .append("/cgi-bin/token?grant_type=client_credential&appid=")
                .append(loginDTO.getAppId())
                .append("&secret=").append(loginDTO.getSecret());

        String responseContext = HttpUtil.get(String.valueOf(jsCode2sessionUrl));
        log.info("code2SessionLogin response context:{}", JSON.toJSONString(responseContext));

        return responseContext;
    }
}
