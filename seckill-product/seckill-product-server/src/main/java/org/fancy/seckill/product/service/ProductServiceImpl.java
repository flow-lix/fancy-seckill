package org.fancy.seckill.product.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.fancy.seckill.common.dto.CommodityDTO;
import org.fancy.seckill.common.resp.Response;
import org.fancy.seckill.common.util.RetResponse;
import org.fancy.seckill.product.api.IProductService;
import org.fancy.seckill.product.entity.ProductEntity;
import org.fancy.seckill.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@DubboService(version = "1.0.0")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductEntity> implements IProductService {

    @Override
    public Response<Object> decreaseStorage(CommodityDTO commodityDTO) {
        log.info("全局事务id ：" + RootContext.getXID());
        int count = baseMapper.decreaseStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        return count > 0 ? RetResponse.makeOKRsp() : RetResponse.makeErrRsp("扣减库存失败");
    }
}
