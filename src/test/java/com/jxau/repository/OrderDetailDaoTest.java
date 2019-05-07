package com.jxau.repository;

import com.jxau.domain.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest(){
        OrderDetail orderDetail =new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("11111112");
        orderDetail.setProductId("123457");
        orderDetail.setProductIcon("http://xxxxx.jpg");
        orderDetail.setProductName("黑米粥");
        orderDetail.setProductPrice(new BigDecimal(3.0));
        orderDetail.setProductQuantity(2);

         OrderDetail result = orderDetailDao.save(orderDetail);

        Assert.assertNotNull(result);
    }




   @Test
   public void findByOrderId(){

       List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId("11111111");
      Assert.assertNotEquals(0,orderDetailList.size());

   }

}