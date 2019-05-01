package com.nonglianwang.core.service;

import com.nonglianwang.core.CoreApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = CoreApplication.class)
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserService userService;


    @Test
    public void test(){


    }
}