package com.jxau.repository;

import com.jxau.domain.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String OPENID  = "110110";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("ZQ");
        orderMaster.setBuyerPhone("18166030601");
        orderMaster.setBuyerAddress("江西农业大学");
        orderMaster.setBuyerOpenid("110111");
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);
    }



    @Test
    public void findByBuyerOpenidTest(){

        PageRequest request = new PageRequest(0,1);

        Page<OrderMaster> result = orderMasterDao.findByBuyerOpenid(OPENID,request);

        System.out.println(result.getTotalElements());
    }

}