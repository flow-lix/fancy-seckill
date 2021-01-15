package org.fancy.order.api;

import org.fancy.seckill.common.dto.OrderDTO;
import org.fancy.seckill.common.resp.Response;

public interface IOrderService {

    Response<Object> createOrder(OrderDTO orderDTO);

}
