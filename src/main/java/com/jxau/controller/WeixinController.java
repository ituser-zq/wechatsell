package com.jxau.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @PackageName:com.jxau.controller
 * @ClassName:WeixinController
 * @Description:  测试微信端校验参数，手动方式
 * @Author: ZQ
 * @Date:2019/05/03 03:53
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
    log.info("#########code={}",code);

    String Url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx9b4f4db6ef3ce9a0&secret=37554e0a9de397c1709e4f60d7c6e418&code="+code+"&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(Url,String.class);
        log.info("########response={}",response);

    }
}
