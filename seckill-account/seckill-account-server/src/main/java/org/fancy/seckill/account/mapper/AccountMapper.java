package org.fancy.seckill.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fancy.seckill.account.entity.AccountEntity;


/**
 * 账号Mapper
 */
public interface AccountMapper extends BaseMapper<AccountEntity> {

    @Update("UPDATE t_account SET amount = amount-#{amount} WHERE user_id = #{userId}")
    int decreaseAccount(@Param("userId") String userId, @Param("amount") Double amount);

    @Select("SELECT * FROM t_account WHERE user_id = #{userId} FOR UPDATE")
    int testGlobalLock(String userId);
}
