package com.command;

public class InterfaceMethodTest04 {
    public static void main(String[] args) {
        AA aa = new BB();
        aa.method2();  // invokeinterface
        AA.method1();  // invokestatic
    }

}


interface AA{
    public static void method1(){

    }

    public default void method2(){

    }
}

class BB implements AA{}
