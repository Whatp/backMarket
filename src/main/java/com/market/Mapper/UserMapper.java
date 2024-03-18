package com.market.Mapper;

import com.market.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from market.user")
    List<User> findAll();

    @Insert("insert into market.user (username, password, name, gender, phone, address, avatar) " +
            "values (#{username}, #{password}, #{name}, #{gender}, #{phone}, #{address}, #{avatar})")
    int insert(User user);

    int update(User user);



    @Select("select * from market.user where username like #{username} limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize, String username);

    @Select("select count(*) from market.user where username like concat('%', #{username}, '%') ")
    Integer selectTotal(String username);
}
