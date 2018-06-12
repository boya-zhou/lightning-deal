package com.seckillhigh.dao;

import com.seckillhigh.entity.MiaoshaOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MiaoShaDAO {
    //TODO

    @Insert("insert into miaosha_order (user_id, goods_id, order_id) value (#{userId}, #{goodsId}, #{orderId})")
    int createOrder(@Param("userId") long userId, @Param("goodsId") long goodsId, @Param("orderId") long orderId);

    @Select("select * from miaosha_order where user_id = #{userId} and goods_id = #{goodsId}")
    MiaoshaOrder getOrder(@Param("userId") long userId, @Param("goodsId") long goodsId);

}
