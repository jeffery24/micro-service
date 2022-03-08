package org.jeff.wx.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author jeff
 * @since 1.0.0
 */
@SpringBootTest
class WxPayServiceTest {

    @Resource
    private WxPayService wxPayService;

    @Test
    void downloadBillV2() {
        wxPayService.downloadBillV2(
               "20220108",
                //LocalDate.now().minusDays(1).toString(),
                "ALL");
    }
}