package com.market.Service;

import com.market.Mapper.UserMapper;
import com.market.exception.ServiceException;
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


    public void delete(Integer id) {
        userMapper.deleteById(id);
    }

    public void deleteIds(List<Integer> ids) {
        userMapper.deleteByIds(ids);
    }

    public User register(User user) {
        User dbUser = userMapper.selectByUsername(user);
        if (dbUser != null) {
            // 抛出一个自定义的异常
            throw new ServiceException("用户名已存在");
        }
//        user.setUsername(user.getUsername());
//        user.setPassword(user.getPassword());
        userMapper.insert(user);
        return user;
    }

    public User login(User user) {
        // 根据用户名查询数据库的用户信息
        User dbUser = userMapper.selectByUsername(user);
        if (dbUser == null) {
            // 抛出一个自定义的异常
            throw new ServiceException("用户名或密码错误");
        }
        if (!user.getPassword().equals(dbUser.getPassword())) {
            throw new ServiceException("用户名或密码错误");
        }
        return dbUser;
    }
}
