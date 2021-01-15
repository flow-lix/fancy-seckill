package org.fancy.seckill.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan({"org.fancy.seckill.order.mapper"})
@EnableDubbo(scanBasePackages = "org.fancy.seckill.order.service")
@SpringBootApplication(scanBasePackages = "org.fancy.seckill.order")
@EnableTransactionManagement
public class SeckillOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillOrderApplication.class, args);
    }

}
