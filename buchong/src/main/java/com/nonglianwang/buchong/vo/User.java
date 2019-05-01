package com.nonglianwang.buchong.vo;

import com.nonglianwang.buchong.util.PageQueryBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class User extends PageQueryBean {

    private static final long serialVersionUID = -2624200514151969998L;
    @Size(min = 10,max = 32)
    private String uno;

    @Length(max = 20,min = 5)
    private String username;

    // 可以用@Post来校验过去的日期
    @Pattern(regexp = "([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))",message = "请输入正确的日期")
    private String borntime;

    @Email(message = "邮箱格式错误")
    private String eMail;

    @Pattern(regexp = "^(男)|(女)$")
    private String sex;

    @Pattern(regexp = "^(普通用户)|(会员用户)|(商家)|(管理员)$")
    private String rname;

    @Pattern(regexp = "^(true)|(false)$")
    private String state;

}
