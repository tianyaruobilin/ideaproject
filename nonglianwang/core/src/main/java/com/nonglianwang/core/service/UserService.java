package com.nonglianwang.core.service;

import com.nonglianwang.core.dao.UserMapper;
import com.nonglianwang.core.domain.User;
import com.nonglianwang.core.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 登陆业务
     * @param user
     * @return
     */
    public User login(LoginUser user){
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("userCode", user.getUserCode());
        List<User> users = userMapper.selectByExample(example);
        for (User sqlUser :
                users) {
            if (DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes()).equals(sqlUser.getUserPassword())) {
                return sqlUser;
            }
        }
        return null;
    }

    /**
     * 注册业务
     * @param user
     * @return
     */
    public Integer register(User user){
        user.setUserCode(String.valueOf(System.currentTimeMillis()).substring(0, 10));
        user.setUserEmail(user.getUserCode()+"@163.com");
        user.setUserCreatedTime(new Date());
        user.setUserUpdatedTime(new Date());
        user.setUserLastLoginTime(new Date());
        user.setUserStatus("已激活");
        String encryptPassword = DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes());
        user.setUserPassword(encryptPassword);
        int insert = userMapper.insert(user);
        return insert;
    }
}
