package com.string;

/**
 * 体会执行效率：
 * 通过StringBuilder的append（）的方式添加字符串的效率要远高于使用String的字符串拼接方式
 * 详情：
 *      1.StringBuilder的append方式，自始自终只创建过一个StringBuilder的对象
 *        使用 String的字符串拼接方式，创建过多个StringBuilder和String的对象
 *
 *      2.使用String的字符串拼接方式，内存中由于创建了较多的StringBuilder和String的对象，
 *        内存占用更大,如果进行GC,需要花费额外的时间
 *
 *  改进的空间：在实际开发中，如果基本确定要前前后后添加的字符串长度不高于某个限定值，建议直接使用构造函数
 *      StringBuilder s = new StringBuilder(highlevel)
 */
public class StringTest8 {
    public static void main(String[] args) {
        long start =System.currentTimeMillis();
        //method1(100000);//7141
        method2(100000);//11
        long end =System.currentTimeMillis();

        System.out.println("花费时间为："+(end-start));

    }

    private static void method2(int highlevel) {
        //只需要创建一个StringBuilder
        StringBuilder src = new StringBuilder();
        for(int i=0;i<highlevel;i++){
            src.append("a");
        }
    }

    private static void method1(int highlevel) {
        String src="";
        for(int i =0;i<highlevel;i++){
            src=src+"a";// 每次循环都会创建一个StringBuilder,String
        }
    }


}
