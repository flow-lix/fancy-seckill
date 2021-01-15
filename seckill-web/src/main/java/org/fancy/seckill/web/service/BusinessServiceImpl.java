package org.fancy.seckill.web.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.fancy.order.api.IOrderService;
import org.fancy.seckill.account.service.IAccountService;
import org.fancy.seckill.common.dto.AccountDTO;
import org.fancy.seckill.common.dto.BusinessDTO;
import org.fancy.seckill.common.dto.CommodityDTO;
import org.fancy.seckill.common.dto.OrderDTO;
import org.fancy.seckill.common.exception.BusinessException;
import org.fancy.seckill.common.resp.Response;
import org.fancy.seckill.common.util.RetResponse;
import org.fancy.seckill.product.api.IProductService;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements IBusinessService{

    @DubboReference(version = "1.0.0")
    private IProductService productService;
    @DubboReference(version = "1.0.0")
    private IAccountService accountService;
    @DubboReference(version = "1.0.0")
    private IOrderService orderService;

    @Override
    @GlobalTransactional(timeoutMills = 30000, name = "seckill-seata-gts")
    public Response<Object> handleBusiness(BusinessDTO businessDTO) {
        // 1. 扣库存
        CommodityDTO commodityDTO = new CommodityDTO();
        commodityDTO.setCommodityCode(businessDTO.getCommodityCode());
        commodityDTO.setCount(businessDTO.getCount());
        Response<Object> response = productService.decreaseStorage(commodityDTO);
        if (!RetResponse.isSuccess(response)) {
            throw new BusinessException();
        }
        // 2. 扣款
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(businessDTO.getUserId());
        accountDTO.setAmount(businessDTO.getAmount());
        response = accountService.decreaseAccount(accountDTO);
        if (!RetResponse.isSuccess(response)) {
            throw new BusinessException();
        }
        // 3. 生成订单
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(businessDTO.getAmount());
        response = orderService.createOrder(orderDTO);
        if (!RetResponse.isSuccess(response)) {
            throw new BusinessException(response.getMsg());
        }
        return RetResponse.makeOKRsp();
    }
}
