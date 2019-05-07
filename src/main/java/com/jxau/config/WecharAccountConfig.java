package com.jxau.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @PackageName:com.jxau.config
 * @ClassName:WecharAccountConfig
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/03 16:03
 */
@Component
@Data
@ConfigurationProperties(prefix = "wechat")
public class WecharAccountConfig {

    private String myAppId;

    private String myAppSecret;

    private String openAppId;

    private String openAppSecret;

    private String mchId;

    private String mchKey;

    private String keyPath;

    private String notifyUrl;


}
