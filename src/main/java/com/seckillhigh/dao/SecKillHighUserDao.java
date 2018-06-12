package com.seckillhigh.dao;

import com.seckillhigh.entity.SecKillHighUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface SecKillHighUserDao {

    @Select("select * from seckillhigh_user where phone_id = #{phoneId}")
    SecKillHighUser queryUser(@Param("phoneId") long phoneId);

    @Insert("insert into seckillhigh_user " +
            "(id, password, salt)" +
            "values" +
            "(null, #{password}, #{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(SecKillHighUser secKillHighUser);

    @Select("select count(*) from seckillhigh_user")
    int countTable();
}
