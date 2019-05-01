package com.itoken.itokenserviceadmin.service;

import com.itoken.itokenserviceadmin.domain.TbSysUser;

public interface AdminService {

    void register(TbSysUser tbSysUser);

    TbSysUser login(String loginCode, String plantPassword);
}
