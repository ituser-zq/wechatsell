package com.jxau.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @PackageName:com.jxau.config
 * @ClassName:WecharMpConfig
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/03 15:56
 */
@Component
public class WecharMpConfig {

    @Autowired
    private WecharAccountConfig wecharAccountConfig;

    @Bean
    public WxMpService weMpService(){
        WxMpService wxMpService = new WxMpServiceImpl();

        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;

    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpInMemoryConfigStorage.setAppId(wecharAccountConfig.getMyAppId());
        wxMpInMemoryConfigStorage.setSecret(wecharAccountConfig.getMyAppSecret());
        return wxMpInMemoryConfigStorage;
    }


}
