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
@CrossOrigin
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有数据
     * @return
     */
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
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门");
        userService.delete(id);
        return Result.success();
    }

    /**
     * 批量删除方法一：
     * @PostMapping("/del/batch")
     * public Result deleteBatch(@RequestBody List<Integer> ids> {
     *     userService.removeByIds(ids);
     *     return Result.success();
     * }
     * 批量删除方法二：
     */
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        userService.deleteIds(ids);
        return Result.success();
    }


    /**
     * 分页查询
     * 接口路径：/user/page?pageNum=1&pageSize=10
     * @RequestParam接受
     * limit第一个参数 = (pageNum - 1) * pageSize
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String name) {
        pageNum = (pageNum - 1) * pageSize;
        name = "%" + name + "%";
        List<User> data = userMapper.selectPage(pageNum, pageSize, name);
        Integer total = userMapper.selectTotal(name);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}
