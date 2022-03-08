package org.jeff.wx.service.impl;


import cn.hutool.core.date.DateUtil;
import com.github.wxpay.sdk.MyWxPayConfig;
import com.github.wxpay.sdk.WXPay;
import lombok.extern.slf4j.Slf4j;
import org.jeff.wx.domain.entity.WxReconciliation;
import org.jeff.wx.service.WxPayService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jeff
 * @since 1.0.0
 */
@Slf4j
@Service
public class WxPayServiceImpl implements WxPayService {

    @Override
    public void downloadBillV2(String billDate, String type) {

        MyWxPayConfig config = new MyWxPayConfig();
        WXPay wxpay = null;
        try {
            wxpay = new WXPay(config);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> data = new HashMap<>();
        data.put("bill_date", billDate);
        // 可用type替换
        data.put("bill_type", "ALL");

        try {
            Map<String, String> resp = wxpay.downloadBill(data);
            if (resp.get("return_code").equals("SUCCESS")) {
                List<WxReconciliation> wxReconciliationList = analyze(String.valueOf(resp));
                // todo 将账单数据存入数据库
            } else {
                System.out.println(resp.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<WxReconciliation> analyze(String billData) {
        log.info("微信对账处理中.................");
        String firstString = "费率备注";
        // 把第一行表头去掉
        String tradeMsg = billData.substring(billData.indexOf(firstString) + firstString.length());

        String secendString = "总交易单数";
        // 去掉汇总数据,去掉`
        String tradeInfo = tradeMsg.substring(0, tradeMsg.indexOf(secendString));

        List<WxReconciliation> billList = new ArrayList<>();

//        System.err.println(tradeInfo);
        // 按行读取数据
        String[] str = tradeInfo.split("\\r\\n");
        int len = str.length;
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                if (str[i].length() > 0) {
                    String[] order = str[i].split(",");
                    WxReconciliation wxReconciliationEntity = new WxReconciliation();

                    wxReconciliationEntity.setWxTransactionTime(DateUtil.parse(order[0].replace("`", "")));
                    wxReconciliationEntity.setPublicAccountId(order[1].replace("`", ""));
                    wxReconciliationEntity.setMerchantNumber(order[2].replace("`", ""));
                    wxReconciliationEntity.setSpecialMerchantNo(order[3].replace("`", ""));
                    wxReconciliationEntity.setDeviceNumber(order[4].replace("`", ""));
                    wxReconciliationEntity.setWechatOrderNo(order[5].replace("`", ""));
                    wxReconciliationEntity.setMerchantOrderNumber(order[6].replace("`", ""));
                    wxReconciliationEntity.setUserId(order[7].replace("`", ""));
                    wxReconciliationEntity.setTransactionType(order[8].replace("`", ""));
                    wxReconciliationEntity.setTradingStatus(order[9].replace("`", ""));
                    wxReconciliationEntity.setPayingBank(order[10].replace("`", ""));
                    wxReconciliationEntity.setCurrencyType(order[11].replace("`", ""));
                    wxReconciliationEntity.setOrderAmountToBeSettled(stringToBigDecimal(order[12].replace("`", "")));
                    wxReconciliationEntity.setVoucherAmount(stringToBigDecimal(order[13].replace("`", "")));
                    wxReconciliationEntity.setWechatRefundNo(order[14].replace("`", ""));
                    wxReconciliationEntity.setMerchantRefundNo(order[15].replace("`", ""));
                    wxReconciliationEntity.setRefundAmount(stringToBigDecimal(order[16].replace("`", "")));
                    wxReconciliationEntity
                            .setRefundAmountOfRechargeVoucher(stringToBigDecimal(order[17].replace("`", "")));
                    wxReconciliationEntity.setRefundType(order[18].replace("`", ""));
                    wxReconciliationEntity.setRefundStatus(order[19].replace("`", ""));
                    wxReconciliationEntity.setTradeName(order[20].replace("`", ""));
                    wxReconciliationEntity.setMerchantPacket(order[21].replace("`", ""));
                    wxReconciliationEntity.setServiceCharge(stringToBigDecimal(order[22].replace("`", "")));
                    wxReconciliationEntity.setRate(order[23].replace("`", ""));
                    wxReconciliationEntity.setOrderAmount(stringToBigDecimal(order[24].replace("`", "")));
                    wxReconciliationEntity
                            .setApplicationForRefundAmount(stringToBigDecimal(order[25].replace("`", "")));
                    wxReconciliationEntity.setRateNotes(order[26].replace("`", ""));

                    log.info("wxReconciliationEntity: {}",wxReconciliationEntity);
                    billList.add(wxReconciliationEntity);
                }
            }
        }
        return billList;
    }

    private static BigDecimal stringToBigDecimal(String number) {
        return new BigDecimal(number);
    }
}
