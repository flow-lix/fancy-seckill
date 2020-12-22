package org.fancy.seckill.web;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.fancy.seckill.facade.account.IAccountService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableDubbo
@SpringBootApplication
public class SeckillWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillWebApplication.class, args);
    }

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private IAccountService demoService;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            System.out.println(demoService.login(null));
        };
    }

}
