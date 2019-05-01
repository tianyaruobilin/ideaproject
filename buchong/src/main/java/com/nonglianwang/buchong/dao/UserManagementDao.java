package com.nonglianwang.buchong.dao;

import com.nonglianwang.buchong.entity.User;
import com.nonglianwang.mybatis.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserManagementDao extends MyMapper<User> {
    List<User> customSelect(com.nonglianwang.buchong.vo.User user); //根据vo.user查询出entity.user集合

    Integer updateByPrimaryKeyVo(com.nonglianwang.buchong.vo.User user);

    Integer insertVo(com.nonglianwang.buchong.vo.User toUpdateData);

    List<User> search(@Param(value = "testKey")Map<String, Object> key);

    List<String> selectRoleName(@Param(value = "uno")String uno);

}
