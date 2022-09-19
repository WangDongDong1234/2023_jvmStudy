package com.demo;

/**
 * 深入立即java虚拟机
 * staticObj   instanceObj  localObj存放在哪里
 */
public class StaticObjTest12 {

    static  class Test{
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo(){
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    private static class ObjectHolder{

    }

    public static void main(String[] args) {
        Test test =new StaticObjTest12.Test();
        test.foo();;
    }
}
