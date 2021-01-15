package org.fancy.seckill.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.fancy.seckill.common.dto.CommodityDTO;
import org.fancy.seckill.common.resp.Response;
import org.fancy.seckill.product.api.IProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private IProductService storageService;

    /**
     * 扣减库存
     */
    @PostMapping("/dec")
    Response<Object> decreaseStorage(@RequestBody CommodityDTO commodityDTO){
        log.info("请求库存微服务：{}", commodityDTO.toString());
        return storageService.decreaseStorage(commodityDTO);
    }

}

