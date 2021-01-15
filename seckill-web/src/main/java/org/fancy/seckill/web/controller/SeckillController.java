package org.fancy.seckill.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.fancy.seckill.common.dto.BusinessDTO;
import org.fancy.seckill.common.resp.Response;
import org.fancy.seckill.web.service.IBusinessService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 发起订单
 */
@Slf4j
@RestController
@RequestMapping("/bus/")
public class SeckillController {

    @Resource
    private IBusinessService businessService;

    /**
     * 模拟用户购买商品下单业务逻辑流程
     */
    @PostMapping("/buy")
    Response<Object> handleBusiness(@RequestBody BusinessDTO businessDTO){
        log.info("请求参数：{}", businessDTO.toString());
        return businessService.handleBusiness(businessDTO);
    }
}
