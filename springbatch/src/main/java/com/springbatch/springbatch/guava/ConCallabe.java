package com.springbatch.springbatch.guava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ConCallabe implements Callable {

    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+":线程开始执行了");
        List<String> listRe=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            //含有'4599'的字符串都返回
            if (list.get(i).contains("4599")) {
                listRe.add(list.get(i));
            }
        }
        return listRe;
    }
}
