package org.fancy.seckill.account.service;

import org.fancy.seckill.common.dto.AccountDTO;
import org.fancy.seckill.common.entity.UserEntity;
import org.fancy.seckill.common.req.LoginReq;
import org.fancy.seckill.common.resp.Response;

public interface IAccountService {

    UserEntity login(LoginReq loginReq);

    Response<Object> decreaseAccount(AccountDTO accountDTO);

    void testGlobalLock();

}
