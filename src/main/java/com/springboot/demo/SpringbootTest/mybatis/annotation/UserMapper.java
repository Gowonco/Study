package com.springboot.demo.SpringbootTest.mybatis.annotation;

import com.springboot.demo.SpringbootTest.mybatis.pojo2.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {


    @Results(value = {
            @Result(property = "id" ,column ="id",id = true),
            @Result(property = "name" ,column ="name"),
            @Result(property = "age" ,column ="age")
    })
    @Select("select id,name ,age from User where id = #{id}")
    User  selectUser(int id);
}
