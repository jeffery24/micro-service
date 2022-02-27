package org.jeff.wx.service;


import org.jeff.wx.domain.dto.WxParameterDTO;
import org.jeff.wx.domain.dto.XcxLoginDTO;

/**
 * 通用对接微信小程序服务
 *
 * @author jeff
 * @since 1.0.0
 */
public interface CommonWxXcxService {

    /**
     * 获取小程序的接口调用凭证 access token
     *
     * @param wxParameterDTO
     * @return JSON 数据包 {access_token,expires_in,errcode,errmsg}
     */
    public Object getAccessToken(WxParameterDTO wxParameterDTO);

    /**
     * 小程序登录
     *
     * @param loginDTO
     * @return
     */
    public Object XcxLogin(XcxLoginDTO loginDTO);

    /**
     * 通过 access_token获取小程序用户手机号
     * <p>
     * 返回结果示例: {
     * "errcode":0,
     * "errmsg":"ok",
     * "phone_info": {
     * "phoneNumber":"xxxxxx",
     * "purePhoneNumber": "xxxxxx",
     * "countryCode": 86,
     * "watermark": {
     * "timestamp": 1637744274,
     * "appid": "xxxx"
     * }
     * }
     * }
     *
     * @param code        小程序code每个code只能消费一次
     * @param accessToken 小程序接口调用权限
     * @return {phone_info,errcode,errmsg}
     */
    //public Object getPhoneNumber(String code, String accessToken);



}
