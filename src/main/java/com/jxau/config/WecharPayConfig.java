package com.jxau.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @PackageName:com.jxau.config
 * @ClassName:WecharPayConfig
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/04 17:32
 */
@Component
public class WecharPayConfig {


    @Autowired
    private WecharAccountConfig wecharAccountConfig;

    @Bean
    public BestPayServiceImpl bestPayService(){

        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(wecharAccountConfig.getMyAppId());
        wxPayH5Config.setAppSecret(wecharAccountConfig.getMyAppSecret());
        wxPayH5Config.setKeyPath(wecharAccountConfig.getKeyPath());
        wxPayH5Config.setMchId(wecharAccountConfig.getMchId());
        wxPayH5Config.setMchKey(wecharAccountConfig.getMchKey());
        wxPayH5Config.setNotifyUrl(wecharAccountConfig.getNotifyUrl());
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();

        bestPayService.setWxPayH5Config(wxPayH5Config);
        return bestPayService;

    }


}
