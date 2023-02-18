package com.string;

public class StringTest13 {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    /**
     * new string( "ab")会创建几个对象﹖看字节码，就知道是两个。
     * 一个对象是: new关键字在堆空间创建的
     * 另一个对象是:字符串常量池中的对象"ab"。字节码指令: Ldc
     */
    private static void test1() {
        String s1 = new String("ab");
        s1.intern();
        String s2="ab";
        System.out.println(s1 ==s2);//false
    }

    /**
     * 这个在常量池中没有生成“ab”
     */
    private static void test2() {
        String s1 = new String("a")+new String("b");
        s1.intern();
        String s2="ab";
        System.out.println(s1 ==s2); //true
    }
}
