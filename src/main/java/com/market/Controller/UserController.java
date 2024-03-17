package com.market.Controller;

import com.market.Mapper.UserMapper;
import com.market.Service.UserService;
import com.market.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

//    查询所有数据
    @GetMapping("/users")
    public List<User> index() {
        List<User> all= userMapper.findAll();
        return all;
    }

    @PostMapping
    public Integer save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }
}
