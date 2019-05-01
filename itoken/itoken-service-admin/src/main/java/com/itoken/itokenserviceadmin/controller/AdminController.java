package com.itoken.itokenserviceadmin.controller;

import com.itoken.itokenserviceadmin.domain.TbSysUser;
import com.itoken.itokenserviceadmin.service.impl.AdminServiceImpl;
import com.itoken.itokenserviceadmin.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    @PostMapping(value = "/regist")
    public Map register(@RequestBody TbSysUser tbSysUser){
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex(tbSysUser.getPassword().getBytes()));
        adminService.register(tbSysUser);
        Map map=new HashMap();
        map.put("message", "success");
        return map;
    }

    @PostMapping(value = "/login")
    public TbSysUser login(@RequestBody LoginUser loginUser){
        TbSysUser login = adminService.login(loginUser.getLoginCode(), loginUser.getPlantPassword());
        return login;
    }
}
