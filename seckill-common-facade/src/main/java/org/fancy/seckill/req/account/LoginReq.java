package org.fancy.seckill.req.account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fancy.seckill.req.AbsReq;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginReq extends AbsReq {

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 手机号 */
    private String phone;

    /** 邮箱 */
    private String mail;

}
