package org.fancy.seckill.product.api;

import org.fancy.seckill.common.dto.CommodityDTO;
import org.fancy.seckill.common.resp.Response;

public interface IProductService {

    Response<Object> decreaseStorage(CommodityDTO commodityDTO);

}
