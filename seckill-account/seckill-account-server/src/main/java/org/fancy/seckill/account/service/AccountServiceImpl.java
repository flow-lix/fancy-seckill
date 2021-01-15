package org.fancy.seckill.account.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalLock;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.fancy.seckill.account.entity.AccountEntity;
import org.fancy.seckill.account.mapper.AccountMapper;
import org.fancy.seckill.common.dto.AccountDTO;
import org.fancy.seckill.common.entity.UserEntity;
import org.fancy.seckill.common.req.LoginReq;
import org.fancy.seckill.common.resp.Response;
import org.fancy.seckill.common.util.RetResponse;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@DubboService(version = "1.0.0")
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountEntity> implements IAccountService {

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
        log.info("Dubbo 登录成功！");
        // 查询成功
//        return userEntityList.get(0);
        return new UserEntity();
    }

    @Override
    public Response<Object> decreaseAccount(AccountDTO accountDTO) {
        int account = baseMapper.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        return account > 0 ? RetResponse.makeOKRsp() : RetResponse.makeErrRsp("账户扣减失败");
    }

    @Override
    @GlobalLock
    @Transactional(rollbackFor = {Throwable.class})
    public void testGlobalLock() {
        baseMapper.testGlobalLock("1");
        log.info("Hi, I got lock, I will do some thing with holding this lock.");
    }
}
