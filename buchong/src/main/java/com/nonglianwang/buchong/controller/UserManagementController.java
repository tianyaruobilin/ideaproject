package com.nonglianwang.buchong.controller;

import com.nonglianwang.buchong.commons.BaseResult;
import com.nonglianwang.buchong.entity.User;
import com.nonglianwang.buchong.service.UserManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@Api(tags = {"用户管理接口"},value = "用户管理")
@RequestMapping(value = "/user")
@CrossOrigin
@Validated
public class UserManagementController {

    private UserManagementService userManagementService;

    @Autowired
    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @ApiOperation(value = "条件查询", notes = "条件查询")
    @PostMapping(value = "/query") //条件查询
    public BaseResult query(@Validated @RequestBody com.nonglianwang.buchong.vo.User user){
        List<User> select = userManagementService.selectcu(user);
        return BaseResult.SUCCESS(select);
    }

    @ApiOperation(value = "分页条件查询",notes = "分页条件查询")
    @PostMapping(value = "/queryAndPage")   //分页条件查询所有
    public BaseResult queryAndPageAll(@RequestBody com.nonglianwang.buchong.vo.User user){
        return userManagementService.queryAndPage(user);
    }

    @ApiOperation(value = "查询所有",notes = "查询所有")
    @GetMapping(value = "/queryAll") //查询所有
    public BaseResult page(){
        List<User> users = userManagementService.selectAll();
        return BaseResult.SUCCESS(users);
    }

    @ApiOperation(value = "修改用户",notes = "修改用户")
    @PatchMapping(value = "/update") //修改，创建
    public BaseResult update(@RequestBody com.nonglianwang.buchong.vo.User toUpdateData){
        System.out.println("toUpdateData = [" + toUpdateData + "]");
        if (toUpdateData.getUno() != null && !"".equals(toUpdateData.getUno())) {
            //不为空,修改
            Integer update = userManagementService.update(toUpdateData);// 不会修改角色类型
            return BaseResult.SUCCESS(toUpdateData);
        }else {
            //uno为空，插入，生成uuid 作为主键
            String uuid = UUID.randomUUID().toString().replace("-", "");
            toUpdateData.setUno(uuid);
            User user=new User();
            BeanUtils.copyProperties(toUpdateData, user);
            user.setPassword(user.getUsername().substring(0, user.getUsername().length()));
            user.setActivationCode("xxxx");
            userManagementService.createNew(user,toUpdateData);
            return BaseResult.SUCCESS(user);
        }
    }

    @ApiOperation(value = "删除用户",notes = "删除用户")
    @DeleteMapping(value = "/delete/{toDeleteUno}") //删除
    public BaseResult delete(@Size(min = 10,max = 32) @PathVariable String toDeleteUno){

        userManagementService.deleteById(toDeleteUno);
        return BaseResult.SUCCESS();
    }

    @ApiOperation(value = "搜索",notes = "搜索")
    @PostMapping(value = "/search") //搜索
    public BaseResult search(@RequestBody Map<String,Object> key){
        return userManagementService.search(key);
    }

    @ApiOperation(value = "根据 uno 查询出所有角色",notes = "根据 uno 查询出所有角色")
    @GetMapping(value = "/selectRoleName/{uno}")    //根据 uno 获取角色
    public BaseResult selectRoleName(@PathVariable String uno){
         return userManagementService.selectRoleName(uno);
    }


}