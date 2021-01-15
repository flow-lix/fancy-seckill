package org.fancy.seckill.account;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan({"org.fancy.seckill.account.mapper"})
@EnableDubbo(scanBasePackages = "org.fancy.seckill.account.service")
@SpringBootApplication(scanBasePackages = "org.fancy.seckill.account")
@EnableTransactionManagement
public class SeckillAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillAccountApplication.class, args);
    }

}
