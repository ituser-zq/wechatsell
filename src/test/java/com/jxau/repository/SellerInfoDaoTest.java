package com.jxau.repository;

import com.jxau.domain.SellerInfo;
import com.jxau.until.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoDaoTest {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Test
    public  void sav(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenId("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setUsername("admin");
        sellerInfo.setSellerId(KeyUtil.getUniqueKey());
        SellerInfo result = sellerInfoDao.save(sellerInfo);

        Assert.assertNotNull(result);

    }
    @Test
    public void findByOpenId(){
        String openId = "admin";
        SellerInfo  result = sellerInfoDao.findByOpenId(openId);
        Assert.assertNotNull(result);
    }

}