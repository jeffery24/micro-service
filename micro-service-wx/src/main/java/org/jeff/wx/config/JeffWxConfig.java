package org.jeff.wx.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author jeff
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "jeff.wx")
@PropertySource("classpath:wx-config/jeff-wx-config.properties")
@Data
public class JeffWxConfig {

    public String appid;

    public String secret;

}

