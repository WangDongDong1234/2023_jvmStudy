package com.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 MinorGC, MajorGC,FullGC
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 */
public class GCTest07 {
    public static void main(String[] args) {
        int i=0;
        try {
            List<String> list = new ArrayList<>();
            String a="atguigu.com";
            while (true){
                list.add(a);
                a=a+a;
                i++;
            }
        }catch (Throwable t){
            t.printStackTrace();
            System.out.println("便利次数："+i);
        }
    }
}
