/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package org.fancy.seckill.facade.account;

import org.fancy.seckill.entity.UserEntity;
import org.fancy.seckill.req.account.LoginReq;

public interface IAccountService {

    UserEntity login(LoginReq loginReq);

}
