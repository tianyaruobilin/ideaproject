package com.study.sstream.stream.streamparallel;

import java.util.stream.Stream;

public class StreamOperate {
    public static long parallel(long n){
        /**
         * 计算结果为（0+1）+(2+3)+(4+5)+(...)...，其中每一个括号为一个线程
         */
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }
}
