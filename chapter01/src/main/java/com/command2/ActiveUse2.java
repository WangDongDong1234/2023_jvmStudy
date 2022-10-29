package com.command2;

import java.util.Random;

public class ActiveUse2 {

    public static void main(String[] args) {
//        test4_A();
//        test4_B();
//        test4_C();
        test5_A();
        test5_B();
    }

    /**
     * 调用类的静态属性，会执行clinit
     */
    public static void test4_A(){
        System.out.println(User.num);
    }

    /**
     * 调用类的静态常量属性，不会执行clinit
     */
    public static void test4_B(){
        System.out.println(User.num1);
    }

    /**
     * 调用类的静态常量引用，会执行clinit
     */
    public static void test4_C(){
        System.out.println(User.num2);
    }

    /**
     * 调用接口的静态常量属性，不会执行clinit
     */
    public static void test5_A(){
        System.out.println(CompareA.NUM1);
    }

    /**
     * 调用接口的静态常量引用，会执行clinit
     */
    public static void test5_B(){
        System.out.println(CompareA.NUM2);
    }
}

class User{
    static {
        System.out.println("User 类的初始化过程");
    }

    public static int num = 1;
    public static final int num1 = 1;
    public static final int num2 = new Random().nextInt(10);
}

interface CompareA{
    public static final Thread t = new Thread(){
        {
            /**
             * 如果接口的静态方法调用了，就会打印这句
             */
            System.out.println("CompareA的初始化");
        }
    };

    public static final int NUM1 =1;
    public static final int NUM2 = new Random().nextInt(10);
}