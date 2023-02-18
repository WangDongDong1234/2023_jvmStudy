package com.string;

import java.util.HashSet;
import java.util.Set;

/**
 * jdk8中  测试溢出
 * -XX:MetaspaceSize=6m -XX:MaxMetaspaceSize=6m -Xms6m -Xmx6m
 */
public class StringTest3 {

    public static void main(String[] args) {
        //使用Set保持着常量池引用，避免full gc回收常量池行为
        Set<String> set = new HashSet<>();
        // 在short可以取值的范围内足以让6MB的PerSize或heap产生OOM了。
        short i =0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
