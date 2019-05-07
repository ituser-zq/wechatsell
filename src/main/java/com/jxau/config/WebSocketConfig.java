package com.jxau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @PackageName:com.jxau.config
 * @ClassName:WebSocketConfig
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/07 13:35
 */
@Component
public class WebSocketConfig {

//    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }


}
