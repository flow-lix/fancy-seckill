package org.fancy.seckill.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
public class AccountDTO implements Serializable {

    @ApiModelProperty(value = "id", notes = "账号id")
    private Integer id;
    @ApiModelProperty(value = "userId", notes = "用户id")
    private String userId;
    @ApiModelProperty(value = "amount", notes = "扣款金额")
    private BigDecimal amount;

}
