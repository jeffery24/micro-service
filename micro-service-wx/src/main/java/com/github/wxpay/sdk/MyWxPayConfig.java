package com.github.wxpay.sdk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.*;

@Configuration
public class MyWxPayConfig extends WXPayConfig {

    @Autowired
    private Environment env;

    private byte[] certData;

    //todo 微信支付相关参数
    private String appId = "";
    private String mchId = "";
    private String mchKey = "";
    private String certPath = "";


    @Override
    public String getAppID() {
//        return env.getProperty("weiXin.appid");
        return this.appId;
    }

    @Override
    public String getMchID() {
//        return env.getProperty("weiXin.mch-id");
        return this.mchId;
    }

    @Override
    public String getKey() {
//        return env.getProperty("weiXin.mch-key");
        return this.mchKey;
    }

    //这里不写在构造方法是因为开发和线上的秘钥文件地址不同
    @Override
    public InputStream getCertStream() {

        try {
            String certPath = this.certPath;
            File file = new File(certPath);
            InputStream certStream = new FileInputStream(file);
            this.certData = new byte[(int) file.length()];
            certStream.read(this.certData);
            certStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public IWXPayDomain getWXPayDomain() {
        IWXPayDomain iwxPayDomain = new IWXPayDomain() {
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
            }

            public DomainInfo getDomain(WXPayConfig config) {
                return new DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };
        return iwxPayDomain;
    }
}