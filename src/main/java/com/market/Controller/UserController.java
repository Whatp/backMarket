package com.market.Controller;

import com.market.Mapper.UserMapper;
import com.market.Service.UserService;
import com.market.pojo.Result;
import com.market.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

//    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }
//    查询所有数据
    @GetMapping
    public Result list() {
        log.info("查看全部员工");
        List<User> userList = userService.list();
        return Result.success(userList);
    }


    @PostMapping
    public Result add(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }



    // 分页查询
    //  接口路径：/user/page?pageNum=1&pageSize=10
    // @RequestParam接受
//    limit第一个参数 = (pageNum - 1) * pageSize
    // pageSize
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String username) {
        pageNum = (pageNum - 1) * pageSize;
        username = "%" + username + "%";
        List<User> data = userMapper.selectPage(pageNum, pageSize, username);
        Integer total = userMapper.selectTotal(username);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}
