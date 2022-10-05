package com.code;

public class StringTest02 {
    public static void main(String[] args) {
        String str = new String("hello")+ new String("world");

        String str1 ="helloworld";
        // str1直接是字符串常量池，str是stringbuilder后的toString()方法重新new的
        System.out.println(str = str1); //false
        String str2 = new String("helloworld");
        System.out.println(str == str2);
    }
}
