package com.market.Service;

import com.market.Mapper.UserMapper;
import com.market.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        if(user.getId() == null) {
            return userMapper.insert(user);
        }
        else {
            return userMapper.update(user);
        }
    }

    public List<User> list() {
        return userMapper.findAll();
    }


}
