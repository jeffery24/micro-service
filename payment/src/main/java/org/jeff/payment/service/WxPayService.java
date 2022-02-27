package org.jeff.payment.service;

import java.util.Map;

/**
 * @author jeff
 * @since 1.0.0
 */
public interface WxPayService {

    /**
     * unifiedorder 统一下单
     *
     * @return
     */
    public Map<String, String> wxPay() throws Exception;
}
