package com.jxau.service.impl;

import com.jxau.domain.OrderDetail;
import com.jxau.dto.OrderDTO;
import com.jxau.enums.OrderStatusEnum;
import com.jxau.enums.PayStatusEnum;
import com.jxau.until.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final  String BUYER_OPENID = "wx9b4f4db6ef3ce9a0";

    private final String ORDER_ID = "123456";
    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(KeyUtil.getUniqueKey());
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerAddress("江西农业大学");
        orderDTO.setBuyerPhone("18166010032");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList =new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(2);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);

        log.info("###########创建订单###########");

    }

    @Test
    public void findOne() {

    OrderDTO result  = orderService.findOne(ORDER_ID);
        Assert.assertNotNull(result);

    }

    @Test
    public void findList() {

        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());

    }

    @Test
    public void cancel() {

        OrderDTO orderDTO =orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertNotEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());

    }

    @Test
    public void finish() {
        OrderDTO orderDTO =orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertNotEquals(OrderStatusEnum.FINISHEN.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {

        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());

    }

    @Test
    public void findListTest(){

        Pageable pageable =new PageRequest(0,2);

        Page<OrderDTO> orderDTOPage = orderService.findList(pageable);

        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());

    }
}