package com.springjwt.springjwt.testcontroller;

import com.springjwt.springjwt.annotation.UserLoginToken;
import com.springjwt.springjwt.commons.entity.User;
import com.springjwt.springjwt.commons.util.TokenCreate;
import com.springjwt.springjwt.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    @Qualifier("tokenServiceImpl")
    private TokenService tokenService;

    //登陆业务
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestBody User user){
        Map jsonObject=new HashMap<>();
        User sqlUser = tokenService.findByUsername(user);
        if (sqlUser == null) {
            jsonObject.put("message", "登陆失败,用户名不存在");
            return jsonObject;
        }else{
            if (!sqlUser.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登陆失败,密码错误");
                return jsonObject;
            }else{
                String token = TokenCreate.getToken(sqlUser);
                jsonObject.put("token", token);
                jsonObject.put("user", sqlUser);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }




}
