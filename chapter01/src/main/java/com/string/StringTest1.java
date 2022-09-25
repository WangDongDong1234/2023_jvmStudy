package com.string;

/**
 * String的不可变性
 */
public class StringTest1 {
    public static void main(String[] args) {

        String s1="abc"; //字面量定义的方式，“abc”存储在字符串常量池中
        String s2="abc";

        System.out.println(s1==s2); // true  判断地址是否相等
    }
}
