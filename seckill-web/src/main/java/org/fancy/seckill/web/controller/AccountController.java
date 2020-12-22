/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package org.fancy.seckill.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.fancy.seckill.facade.account.IAccountService;
import org.fancy.seckill.req.account.LoginReq;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345")
    private IAccountService accountService;

    @GetMapping("/login")
    public void login(LoginReq loginReq) {
        accountService.login(loginReq);
    }
}
