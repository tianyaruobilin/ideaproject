package com.nonglianwang.buchong.dao;

import com.nonglianwang.buchong.BuchongApplication;
import com.nonglianwang.buchong.entity.User;
import com.nonglianwang.buchong.util.AckUserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest(classes = BuchongApplication.class)
@RunWith(SpringRunner.class)
@Transactional(readOnly = true)
@Rollback
public class UserManagementDaoTest {

    @Autowired
    UserManagementDao userManagementDao;

    @Test
    public void query(){
        List<User> users = userManagementDao.selectAll();
        for (User user :
                users) {
            System.out.println(user);
        }
    }

    @Test
    public void search(){
        Map<String,Object> map=new HashMap<>();
        map.put("currentPage", 1);
        map.put("pageSize", 5);
        map.put("search", "lirunmin");

        userManagementDao.search(map);
    }

    @Test
    public void ttt(){
        List<String> roles = userManagementDao.selectRoleName("c89f88c0a0084ca981ae3b5a00e70116");
        String role = AckUserRole.getRole(roles);
        System.out.println(role);
    }

}