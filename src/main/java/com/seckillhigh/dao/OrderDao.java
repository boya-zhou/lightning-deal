package com.seckillhigh.dao;


import com.seckillhigh.entity.OrderInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderDao {

    @Select("select * from order_info where user_id = #{userId} and goods_id = #{goodsId}")
    OrderInfo getOrder(@Param("userId") long userId, @Param("goodsId") long goodsId);

    @Insert("insert into order_info" +
            "(id, user_id, goods_id, goods_name, goods_count, goods_price, status, create_date)" +
            "values" +
            "(null, #{userId}, #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{status}, #{createDate})")
    @Options(useGeneratedKeys=true, keyProperty="id")
//    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    int createOrder(OrderInfo orderInfo);
}
