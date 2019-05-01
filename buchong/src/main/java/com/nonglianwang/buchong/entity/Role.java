package com.nonglianwang.buchong.entity;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "tb_role")
public class Role {
    private String rno;
    private String rname;
}
