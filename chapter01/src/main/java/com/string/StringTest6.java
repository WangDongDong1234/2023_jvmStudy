package com.string;

public class StringTest6 {
    public static void main(String[] args) {
        String s1 ="a"+"b"+"c";  //等同于”abc"
        String s2 ="abc";  //"abc"一定是放在字符串常量池中，将此地址赋给s2
        /**
         * 最终 java编译成class,在执行class
         * String s1 ="abc"
         * String s2 ="abc"
         */
        System.out.println(s1==s2); //true
        System.out.println(s1.equals(s2)); //true
    }
}
