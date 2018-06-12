package com.seckillhigh.dao;

import com.seckillhigh.vo.MiaoshaGoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MiaoshaGoodsDao {

    @Select(
            "select g.*, mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date" +
                    " from miaosha_goods mg left join goods g" +
                    " on g.id = mg.goods_id"
    )
    List<MiaoshaGoodsVo> getMiaoshaGoods();

    @Select(
            "select g.*, mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date" +
                    " from miaosha_goods mg left join goods g" +
                    " on g.id = mg.goods_id" +
                    " where g.id = #{id}"
    )
    MiaoshaGoodsVo getMiaoshaGood(@Param("id") long id);

    @Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId}")
    int decurStock(@Param("goodsId") long goodsId);




}
