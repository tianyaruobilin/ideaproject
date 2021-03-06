package com.itoken.itokenserviceadmin.service.impl;

import com.itoken.itokenserviceadmin.domain.TbSysUser;
import com.itoken.itokenserviceadmin.mapper.TbSysUserMapper;
import com.itoken.itokenserviceadmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;


@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {

    @Autowired
    TbSysUserMapper tbSysUserMapper;

    @Transactional(readOnly = false)
    @Override
    public void register(TbSysUser tbSysUser) {
        tbSysUserMapper.insert(tbSysUser);
    }

    @Override
    public TbSysUser login(String loginCode, String plantPassword) {
        Example example = new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode", loginCode);

        TbSysUser tbSysUser = tbSysUserMapper.selectOneByExample(example);
        if (tbSysUser != null) {
            String password = DigestUtils.md5DigestAsHex(plantPassword.getBytes());
            if (password.equals(tbSysUser.getPassword())) {
                return tbSysUser;
            }
        }

        return null;
    }
}
