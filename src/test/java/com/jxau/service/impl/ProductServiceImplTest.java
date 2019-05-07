package com.jxau.service.impl;

import com.jxau.domain.ProductInfo;
import com.jxau.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo p = productService.findOne("123456");
        Assert.assertNotEquals(0,p.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productService.findUpAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findAll1() {
        PageRequest requset = new PageRequest(0,2);

        Page<ProductInfo> page = productService.findAll(requset);

       System.out.println(page.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("面");
        productInfo.setProductPrice(new BigDecimal(9.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好吃");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        productService
                .save(productInfo);
    }
    @Test
    public void test(){
        ProductInfo result = productService.onSale("123456");
        Assert.assertNotEquals(result.getProductStatus(),ProductStatusEnum.UP);
    }
}