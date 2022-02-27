package org.jeff.wx.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jeff.wx.constant.WxConfigConstant;

/**
 * 小程序 API
 *
 * @author jeff
 * @since 1.0.0
 */
@AllArgsConstructor
@Getter
public enum XCXApiType {

    /**
     * 小程序登录
     */
    LOGIN_URL(WxConfigConstant.BASE_URL + "/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code"),
    /**
     * 获取 access_token
     */
    ACCESS_TOKEN(WxConfigConstant.BASE_URL + "/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET"),
    /**
     * 获取手机号
     */
    GET_PHONE_NUMBER(WxConfigConstant.BASE_URL + "/wxa/business/getuserphonenumber?access_token=ACCESS_TOKEN");

    private final String type;
}
