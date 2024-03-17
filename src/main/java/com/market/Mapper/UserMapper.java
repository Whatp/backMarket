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

    @Delete("delete from market.user where id = #{id}")
    Integer deleteById(Integer id);
}
