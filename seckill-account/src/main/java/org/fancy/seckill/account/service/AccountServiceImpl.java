package org.fancy.seckill.account.service;

import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.fancy.seckill.entity.UserEntity;
import org.fancy.seckill.facade.account.IAccountService;
import org.fancy.seckill.req.account.LoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@DubboService(version = "1.0.0")
public class AccountServiceImpl implements IAccountService {

    /** 用户表主键的前缀 */
    private static final String USER_KEY_PREFIX = "USER";

    @Override
    public UserEntity login(LoginReq loginReq) {
        // 校验参数
//        checkParam(loginReq);

        // 创建用户查询请求
//        UserQueryReq userQueryReq = buildUserQueryReq(loginReq);

        // 查询用户
//        List<UserEntity> userEntityList = userDAO.findUsers(userQueryReq);

        // 查询失败
//        if (CollectionUtils.isEmpty(userEntityList)) {
//            throw new CommonBizException(ExpCodeEnum.LOGIN_FAIL);
//        }

        // 查询成功
//        return userEntityList.get(0);
        return new UserEntity();
    }

}
