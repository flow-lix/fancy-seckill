package org.fancy.seckill.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.fancy.seckill.product.entity.ProductEntity;

public interface ProductMapper extends BaseMapper<ProductEntity> {

    @Update("UPDATE t_storage SET count = count-${count} WHERE commodity_code = #{commodityCode}")
    int decreaseStorage(@Param("commodityCode") String commodityCode, @Param("count") Integer count);

}
