package com.demo;

import java.util.Date;

public class LocalVariablesTest03 {
    private int count = 0;

    public static void main(String[] args) {
        LocalVariablesTest03 localVariablesTest03 = new LocalVariablesTest03();
        int num = 10;
        localVariablesTest03.test1();
    }

    public LocalVariablesTest03() {
        this.count=0;
    }

    private void test1() {
        Date date = new Date();
        String name1="baidu.com";
        String info =test2(date,name1);
        System.out.println(info);
        System.out.println(date+name1);
    }

    private String test2(Date date, String name1) {
        date = null;
        name1 = "xiexu";
        double weight =185.5;
        char gender ='男';
        return date+name1;

    }


}
