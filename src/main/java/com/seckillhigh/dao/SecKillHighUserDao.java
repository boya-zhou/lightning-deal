package com.seckillhigh.dao;

import com.seckillhigh.entity.SecKillHighUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface SecKillHighUserDao {

    @Select("select * from seckillhigh_user where phone_id = #{phoneId}")
    SecKillHighUser queryUser(@Param("phoneId") long phoneId);

}
