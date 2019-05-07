package com.jxau.service.impl;

import com.jxau.dto.OrderDTO;
import com.jxau.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @PackageName:com.jxau.service.impl
 * @ClassName:PushMessageServiceImpl
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/07 13:19
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

    @Qualifier("wxOpenService")
    @Autowired
    private WxMpService wxMpService;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId("1yZN2zlDiVeagU1QHEGHOsk1n259Wrbs1sDNq2hcrQc");
        templateMessage.setToUser("oYmtC1VwjK75EwFhmNOZynQPBcVI");
                List<WxMpTemplateData> list = Arrays.asList(
                new WxMpTemplateData("first","恭喜你支付成功 下单时间"),
                new WxMpTemplateData("money","支付金额"),
                new WxMpTemplateData("order","订单号")
        );

        templateMessage.setData(list);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        }catch (WxErrorException e){
            log.info("##########微信消息模板发送失败######");
        }



    }
}
