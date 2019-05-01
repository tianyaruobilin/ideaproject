package com.itoken.itokenserviceadmin.service.impl;

import com.itoken.itokenserviceadmin.ItokenServiceAdminApplication;
import com.itoken.itokenserviceadmin.domain.TbSysUser;
import com.itoken.itokenserviceadmin.service.AdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItokenServiceAdminApplication.class)
//@ActiveProfiles(value = "prod")
@Transactional
@Rollback
public class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void register() {
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setUserCode(UUID.randomUUID().toString());
        tbSysUser.setLoginCode("lusifer@funtl.com");
        tbSysUser.setUserName("Lusifer");
        tbSysUser.setUserType("1");
        tbSysUser.setMgrType("1");
        tbSysUser.setStatus("0");
        tbSysUser.setCreateBy(tbSysUser.getUserCode());
        tbSysUser.setCreateDate(new Date());
        tbSysUser.setUpdateBy(tbSysUser.getUserCode());
        tbSysUser.setUpdateDate(new Date());
        tbSysUser.setCorpCode("0");
        tbSysUser.setCorpName("iToken");
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        adminService.register(tbSysUser);
    }

    @Test
    public void login() {
        TbSysUser tbSysUser = adminService.login("lusifer@funtl.com", "123456");
        Assert.assertNotNull(tbSysUser);
    }
}