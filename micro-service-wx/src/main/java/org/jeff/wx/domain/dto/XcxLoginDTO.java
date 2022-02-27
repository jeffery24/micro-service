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
public class XcxLoginDTO extends WxParameterDTO implements Serializable {

    private static final long serialVersionUID = 6662643661194537341L;

    /**
     * 前端从微信拿到的code
     */
    private String code;

}
