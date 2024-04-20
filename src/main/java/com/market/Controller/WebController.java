package com.market.Controller;

import cn.hutool.core.util.StrUtil;
import com.market.Service.UserService;
import com.market.common.AuthAccess;
import com.market.common.Result;
import com.market.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class WebController {
    @Autowired
    private UserService userService;

//    这个方法用来检查后台接口是否正常运行
    @AuthAccess
    @GetMapping("/")
    public Result hello() {
        return Result.success("success");
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if (StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())) {
            return Result.error("数据输入不合法");
        }
        User u = userService.login(user);
        return Result.success(u);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())) {
            return Result.error("数据输入不合法");
        }
        if (user.getUsername().length() > 10 || user.getPassword().length() > 20) {
            return Result.error("数据输入不合法");
        }
        user = userService.register(user);
        return Result.success(user);
    }

}
