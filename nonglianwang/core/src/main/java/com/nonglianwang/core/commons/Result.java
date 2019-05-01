package com.nonglianwang.core.commons;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum  Result{
    ok(1,"操作成功"),
    not_ok(0,"操作失败");


    private int code;
    private String msg;

}
