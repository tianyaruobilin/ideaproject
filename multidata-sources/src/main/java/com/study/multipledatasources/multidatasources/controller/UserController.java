package com.study.multipledatasources.multidatasources.controller;

import com.study.multipledatasources.multidatasources.user_info_0_dao.UserMapperTest1;
import com.study.multipledatasources.multidatasources.user_info_1_dao.UserMapperTest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapperTest1 userMapperTest1;

    @Autowired
    private UserMapperTest2 userMapperTest2;

    @RequestMapping("insert001")
    public String insert001(String userId,String userName,String account,String password){
        userMapperTest1.insertUser(userId, userName, account, password);
        return "success";
    }

    public String insert002(String userId, String userName, String account, String password) {
        userMapperTest2.insertUser(userId, userName, account, password);
        return "success";
    }
}
