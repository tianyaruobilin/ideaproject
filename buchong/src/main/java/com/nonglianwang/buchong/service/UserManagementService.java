package com.nonglianwang.buchong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nonglianwang.buchong.commons.BaseResult;
import com.nonglianwang.buchong.commons.Cursor;
import com.nonglianwang.buchong.dao.RoleManagementDao;
import com.nonglianwang.buchong.dao.UserManagementDao;
import com.nonglianwang.buchong.dao.UserRoleMapperDao;
import com.nonglianwang.buchong.entity.Role;
import com.nonglianwang.buchong.entity.User;
import com.nonglianwang.buchong.entity.UserRole;
import com.nonglianwang.buchong.util.AckUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserManagementService extends BaseService<UserManagementDao, User>{

    @Autowired
    private UserManagementDao userManagementDao;

    @Autowired
    private UserRoleMapperDao userRoleMapperDao;

    @Autowired
    private RoleManagementDao roleManagementDao;

    public BaseResult selectRoleName(String uno) {
        //返回值：
        List<String> roleName = userManagementDao.selectRoleName(uno);
        String role = AckUserRole.getRole(roleName);
//        List<String> roles=new ArrayList<String>();
//        roles.add(role);
        return BaseResult.SUCCESS(role);
    }

    public List<User> selectcu(com.nonglianwang.buchong.vo.User user) {
        return userManagementDao.customSelect(user);
    }

    public Integer update(com.nonglianwang.buchong.vo.User user){
        return userManagementDao.updateByPrimaryKeyVo(user);
    }

    public Integer add(com.nonglianwang.buchong.vo.User toUpdateData) {
        return userManagementDao.insertVo(toUpdateData);
    }

    @Transactional
    public void createNew(User user, com.nonglianwang.buchong.vo.User toUpdateData) {
        userManagementDao.insert(user);
        Role role=new Role();
        role.setRname(toUpdateData.getRname());
        Role role1 = roleManagementDao.selectOne(role);
        UserRole userRole=new UserRole();
        userRole.setUno(user.getUno());
        userRole.setRno(role1.getRno());

        userRoleMapperDao.insert(userRole);
    }

    public void deleteById(String toDeleteUno) {
        //TODO 不能删除数据，应该修改状态为false  , ==>已完成
        User user = new User();
        user.setUno(toDeleteUno);
        user.setState("false");
        userManagementDao.updateByPrimaryKeySelective(user);
    }

    public BaseResult queryAndPage(com.nonglianwang.buchong.vo.User user) {
        PageHelper.startPage(user.getCurrentPage(), user.getPageSize(),true);
        List<User> users = userManagementDao.customSelect(user);
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        Cursor cursor=new Cursor();
        cursor.setTotal((int) pageInfo.getTotal());
        cursor.setLimit(user.getPageSize());
        cursor.setOffset(user.getPageSize());
        return BaseResult.SUCCESS(users, cursor);
    }

    //搜索
    public BaseResult search(Map<String, Object> key) {
        PageHelper.startPage((int)key.get("currentPage"),(int)key.get("pageSize"),true);
        List<User> users=userManagementDao.search(key);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        Cursor cursor=new Cursor();
        cursor.setTotal((int) pageInfo.getTotal());
        cursor.setLimit((int)key.get("pageSize"));
        cursor.setOffset((int)key.get("currentPage")*(int)key.get("pageSize"));
        return BaseResult.SUCCESS(users,cursor);
    }
}
