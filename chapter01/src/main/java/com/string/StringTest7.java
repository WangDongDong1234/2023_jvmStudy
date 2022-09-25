package com.string;

public class StringTest7 {
    public static void main(String[] args) {
        String s1="javaEE";
        String s2="hadoop";

        String s3="javaEEhadoop";
        String s4="javaEE"+"hadoop";  //编译期优化

        //如果拼接符号的前后出现了变量，则相当于在堆空间new String(),具体内容为拼接的结果
        String s5 = s1+"hadoop";
        String s6 = "javaEE"+s2;
        String s7 = s1+s2;

        System.out.println(s3==s4); //true
        System.out.println(s3==s5); // false
        System.out.println(s3==s6); // false
        System.out.println(s3==s7); // false
        System.out.println(s5==s6); // false
        System.out.println(s5==s7);// false
        System.out.println(s6==s7);// false

        // 判断字符串常量池中是否存在该值，如果存在，则返回常量池中该值的地址，
        // 如果字符串常量池中不存在该值，则在常量池中加载一份该值，并返回对象的地址。
        String s8=s6.intern();
        System.out.println(s3==s8); //true

        System.out.println();
    }
}
