package com.market.Mapper;

import com.market.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from market.user")
    List<User> findAll();

    @Insert("insert into market.user (username, password, name, gender, phone, address) " +
            "values (#{username}, #{password}, #{name}, #{gender}, #{phone}, #{address})")
    int insert(User user);

    int update(User user);

    @Delete("delete from market.user where id=#{id}")
    void deleteById(Integer id);

    @Select("select * from market.user where name like #{name} limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize, String name);

    @Select("select count(*) from market.user where name like concat('%', #{name}, '%') ")
    Integer selectTotal(String name);
}
