package com.itoken.itokenserviceadmin.mapper;

import com.itoken.itokenserviceadmin.ItokenServiceAdminApplication;
import com.itoken.itokenserviceadmin.domain.TbSysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@SpringBootTest(classes = ItokenServiceAdminApplication.class)
@RunWith(SpringRunner.class)
public class TbSysUserMapperTest {

    @Autowired
    TbSysUserMapper tbSysUserMapper;

    @Test
    public void testRegist(){
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
        tbSysUserMapper.insert(tbSysUser);
    }

}