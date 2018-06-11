package com.seckillhigh.dao;

import com.seckillhigh.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodsDao {

    @Select(
            "select g.*, mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date" +
                    " from miaosha_goods mg left join goods g" +
                    " on g.id = mg.goods_id"
    )
    GoodsVo getMiaoshaGoods();

}
