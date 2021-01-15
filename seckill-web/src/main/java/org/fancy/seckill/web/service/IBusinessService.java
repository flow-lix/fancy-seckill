package org.fancy.seckill.web.service;

import org.fancy.seckill.common.dto.BusinessDTO;
import org.fancy.seckill.common.resp.Response;

public interface IBusinessService {

    Response<Object> handleBusiness(BusinessDTO businessDTO);

}
