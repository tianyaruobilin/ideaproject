package com.nonglianwang.core.controller;

import com.nonglianwang.core.commons.BaseResult;
import com.nonglianwang.core.domain.User;
import com.nonglianwang.core.service.UserService;
import com.nonglianwang.core.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(@Validated  User user, Model model){
/*        //在这里，我们判断参数是否通过校验
        if (bindResult.hasErrors()){
            for (FieldError fieldError: bindResult.getFieldErrors()) {
                System.out.println(fieldError.getDefaultMessage());
            }
        }*/


        Integer register = userService.register(user);
        model.addAttribute("register", BaseResult.SUCCESS());
        return "dengl";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@Valid LoginUser user, Model model){
        User login = userService.login(user);
        model.addAttribute("loginUser", BaseResult.SUCCESS(login));
        return "index";
    }
}
