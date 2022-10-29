package com.command2;

import java.util.Random;

public class ActiveUse3 {

    public static void main(String[] args) {
        //test6();
        //test7();
        test8();
    }

    /**
     *Class.forName 方法
     */
    public static void test6(){
        try {
            Class clazz =  Class.forName("com.command2.Order");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 先初始化父类后初始化子类,但是不会初始化接口(接口包括父接口)
     */
    public static void test7(){
        System.out.println(Son.num);
    }

    /**
     * 子接口初始化的时候，父接口不会初始化
     */
    public static void test8(){
        System.out.println(CompareC.NUM1);
    }
}


class Father{
    static {
        System.out.println("Father 初始化");
    }
}

class Son extends  Father implements CompareC{
    static {
        System.out.println("Son 初始化");
    }

    public static int num=1;
}

interface CompareB{
    public static final Thread t = new Thread(){
        {
            /**
             * 如果接口的静态方法调用了，就会打印这句
             */
            System.out.println("CompareB的初始化");
        }
    };

}

interface CompareC extends CompareB{
    public static final Thread t = new Thread(){
        {
            /**
             * 如果接口的静态方法调用了，就会打印这句
             */
            System.out.println("CompareC的初始化");
        }

    };

    public static final int NUM1 = new Random().nextInt(10);

}