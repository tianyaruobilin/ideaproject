package com.nonglianwang.core.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginUser {
    @Length(min = 3,max = 10,message = "昵称必须在3-10个字符串长度之间")
    private String userCode;
    @Length(min = 3,max = 10,message = "密码必须在3-10个字符串长度之间")
    private String userPassword;
}
