package com.bharath.springcloud.security.events;

import com.bharath.springcloud.security.entities.Coupon;
import com.bharath.springcloud.security.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    CouponRepo couponRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Coupon coupon = couponRepo.findByCode("abc123");
        if (Objects.isNull(coupon)) {
            coupon = new Coupon();
            coupon.setCode("abc123");
            coupon.setDiscount(new BigDecimal(10));
            coupon.setExpDate("10-11-2024");
            couponRepo.save(coupon);
        }

    }
}
