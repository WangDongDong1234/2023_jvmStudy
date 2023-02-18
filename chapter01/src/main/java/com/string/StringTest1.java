package com.string;

/**
 * String的不可变性
 */
public class StringTest1 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1(){
        String s1="abc"; //字面量定义的方式，“abc”存储在字符串常量池中,s1返回的是“abc”在常量池的地址
        String s2="abc"; //字面量定义的方式，“abc”存储在字符串常量池中,s1返回的是“abc”在常量池的地址

        System.out.println(s1==s2); // true  判断地址是否相等
    }

    public static void test2(){
        String s1="abc";
        String s2="abc";
        s2+="def"; //只要做了修改，就重新创建
        String s3=s2+"def";
        System.out.println(s1); //abc
        System.out.println(s2); //abcdef
        System.out.println(s2==s3);  //false,需要解释
    }

    public static void test3(){
        String s1="abc";
        String s2=s1.replace('a','m');

        System.out.println(s1); //abc
        System.out.println(s2); //mbc

    }
}
