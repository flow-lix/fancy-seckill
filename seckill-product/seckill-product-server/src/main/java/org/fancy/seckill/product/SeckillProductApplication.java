package org.fancy.seckill.product;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan({"org.fancy.seckill.product.mapper"})
@EnableDubbo(scanBasePackages = "org.fancy.seckill.product.service")
@SpringBootApplication(scanBasePackages = {"org.fancy.seckill.product"})
@EnableTransactionManagement
public class SeckillProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillProductApplication.class, args);
    }

}
