package com.jxau.aspect;


import com.jxau.Exception.SellerAuthorizeException;
import com.jxau.constant.Constant;
import com.jxau.until.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @PackageName:com.jxau.aspect
 * @ClassName:SellerAuthorizeAspect
 * @Description: 切面校验，使用微信端扫码登录切面校验登录
 * @Author: ZQ
 * @Date:2019/05/06 19:30
 */
//@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

//    @Pointcut("execution(public * com.jxau.controller.Seller*.*(..))" +
//            "&& !execution(public * com.jxau.controller.SellerUserController.*(..))")
    public void verify(){

    }

//    @Before("verify()")
    public void doVerify(){

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Cookie cookie = CookieUtil.get(request, Constant.TOKEN);
        if(cookie == null){
            log.warn("#####登录校验，查询不到token####");
            throw new SellerAuthorizeException();
        }
        String tokenValue = redisTemplate.opsForValue().get(String.format(Constant.TOKEN_PREFIX));
        if(StringUtils.isEmpty(tokenValue)){
            log.warn("######redis查询不到#####");
            throw new SellerAuthorizeException();
        }



    }


}
