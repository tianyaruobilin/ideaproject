package com.nonglianwang.buchong.commons;


import lombok.Data;

@Data
public class Cursor {
    private int total;  //全部条数
    private int offset; //当前所在的位置
    private int limit;  //每页条数
}
