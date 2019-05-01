package com.nonglianwang.buchong.event.awarestudy;

import com.nonglianwang.buchong.entity.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 封装用户注册的参数为User类，并调用service进行注册
 */
@Api(tags = "用户注册接口,用于自我测试")
@RestController
@RequestMapping("/userRegisterEvent")
public class UserRegisterController {

    @Autowired
    private UserRegisterService userRegisterService;



    @PostMapping("/register")
    public String register(@RequestBody User user){


        Boolean register = userRegisterService.register(user);
        if (register) {
            return "[controller]注册用户成功！";
        }
        return "异常";
    }
}
