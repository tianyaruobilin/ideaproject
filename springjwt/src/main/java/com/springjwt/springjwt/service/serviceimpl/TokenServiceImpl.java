package com.springjwt.springjwt.service.serviceimpl;

import com.springjwt.springjwt.commons.entity.User;
import com.springjwt.springjwt.service.TokenService;
import org.springframework.stereotype.Service;

@Service("tokenServiceImpl")    //默认id为类名首字母小写，所以这里可以省略括号里面的内容
public class TokenServiceImpl implements TokenService {

    @Override
    public User findUserById(String userId) {
        return new User("12", "测试用户", "password");
    }

    @Override
    public User findByUsername(User user) {
        return new User("12", "测试用户", "password");
    }
}
