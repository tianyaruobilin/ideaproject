package com.nonglianwang.buchong.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_user")
@Data
public class User {
    @Id
    private String uno;
    private String username;
    private String password;
    private String borntime;
    private String eMail;
    private String sex;
    @Column(name = "activationCode")
    private String activationCode;
    private String state;

//    private List<Role> userRoleNames;

}
