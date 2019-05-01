package com.study.multipledatasources.multidatasources.user_info_0_dao;

import com.study.multipledatasources.multidatasources.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapperTest1 {

    @Select("select * from user_info_0 where userId=#{userId}")
    public UserInfo findById(@Param("userId") String userId);

    @Insert("insert into user_info_0(userId,userName,account,password) values (#{userId},#{userName},#{accout},#{password})")
    public int insertUser(@Param("userId")String userId,@Param("userName")String userName,@Param("account")String accout,@Param("password")String password);

}
