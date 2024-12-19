package com.zh.mapper;

import com.zh.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{userName}")
    User findByUserName(String userName);

    @Insert("insert into user(username,password,create_time,update_time)" +
            " values(#{userName},#{password},now(),now())")
    void registerUser(String userName,String password);
}
