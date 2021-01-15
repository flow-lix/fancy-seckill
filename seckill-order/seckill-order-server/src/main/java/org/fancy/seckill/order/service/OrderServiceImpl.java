package org.fancy.seckill.order.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.fancy.order.api.IOrderService;
import org.fancy.seckill.common.dto.OrderDTO;
import org.fancy.seckill.common.resp.Response;
import org.fancy.seckill.common.util.RetResponse;
import org.fancy.seckill.order.entity.OrderEntity;
import org.fancy.seckill.order.mapper.OrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@DubboService(version = "1.0.0")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements IOrderService {

    @Override
    public Response<Object> createOrder(OrderDTO orderDTO) {
        log.info("全局事务id ：{}", RootContext.getXID());
        orderDTO.setOrderNo(UUID.randomUUID().toString().replaceAll("-", ""));
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(orderDTO, orderEntity);
        orderEntity.setCount(orderDTO.getOrderCount());
        orderEntity.setAmount(orderDTO.getOrderAmount().doubleValue());
        try {
            baseMapper.insert(orderEntity);
        } catch (Exception e) {
            log.error("创建订单失败", e);
            return RetResponse.makeErrRsp(e.getMessage());
        }
        return RetResponse.makeOKRsp();
    }
}
