package org.jeff.wx.service;


/**
 * @author jeff
 * @since 1.0.0
 */
public interface WxPayService {

    /**
     * v2下载交易账单
     *
     * @param billDate 账单日期
     * @param type
     */
    void downloadBillV2(String billDate, String type);
}
