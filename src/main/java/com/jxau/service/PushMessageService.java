package com.jxau.service;

import com.jxau.dto.OrderDTO;


/**
 * @PackageName:com.jxau.service
 * @ClassName:PushMessageService
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/07 13:18
 */
public interface PushMessageService {

    void orderStatus(OrderDTO orderDTO);
}
