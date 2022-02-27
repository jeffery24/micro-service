package org.jeff.wx.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 小程序所需基础参数
 *
 * @author jeff
 * @since 1.0.0
 */
@Data
public class WxParameterDTO implements Serializable {

    private static final long serialVersionUID = 6662643661194537341L;

    /**
     * 小程序的 appId
     */
    private String appId;
    /**
     * 小程序的密钥
     */
    private String secret;
}
