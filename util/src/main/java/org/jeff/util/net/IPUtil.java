package org.jeff.util.net;

import javax.servlet.http.HttpServletRequest;

/**
 * IP 工具类
 *
 * @author jeff
 * @since 1.0.0
 */
public class IPUtil {

    /**
     * 使用 nginx 做反向代理，需要用该方法才能取到真实的远程IP
     *
     * @param request
     * @return
     */
    public static String getRemoteIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


}
