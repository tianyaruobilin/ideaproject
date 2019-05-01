package com.study.sstream.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {

    /**
     * Lambda 遍历
     */
    public static void testForeach(){
        // 定义一个数组
        String[] array={
                "尼尔机械纪元",
                "关于我转生成史莱姆这件事",
                "实力至上主义教师",
                "地狱少女",
                "穆桂英挂帅"
        };

        // 转换成集合
        //noinspection RedundantCollectionOperation
        List<String> strings = Arrays.asList(array);

        // 传统的遍历方式
        System.out.println("传统的遍历方式");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();

        // 使用 Lambda 表达式以及函数操作（function operation）
        System.out.println("Lambda 表达式以及函数操作");
        strings.forEach(System.out::println);
        System.out.println();
    }

    public static void testStreamDuplicates(){
        System.out.println("Stream 去重复");

        //定义一个数组
        String[] array={
                "穆桂英挂帅",
                "双阳公主",
                "锁麟囊",
                "红娘",
                "铡美案",
                "武家坡",
                "一见娇儿",
                "四郎探母",
                "辕门斩子",
                "定军山"
        };

        // 转换成集合
        List<String> strings = Arrays.asList(array);

        strings.stream().distinct().collect(Collectors.toList());

        // 打印
        strings.forEach(System.out::println);
    }
}
