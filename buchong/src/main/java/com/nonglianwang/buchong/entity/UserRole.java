package com.nonglianwang.buchong.entity;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "tb_user_role")
public class UserRole {
    private String uno;
    private String rno;
}
