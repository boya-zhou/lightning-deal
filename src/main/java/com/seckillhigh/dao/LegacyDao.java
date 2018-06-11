package com.seckillhigh.dao;

import com.seckillhigh.entity.LegacyItems;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LegacyDao {

    @Select("select name from seckill_warehouse where item_Id = #{itemId}")
    String queryItemName(@Param("itemId") int itemId);

    @Select("select * from seckill_warehouse where item_Id = #{itemId}")
    LegacyItems queryItem(@Param("itemId") int itemId);

}
