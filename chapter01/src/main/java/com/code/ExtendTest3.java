package com.code;

public class ExtendTest3 {
    public static void main(String[] args) {
        Father father = new Son();
        System.out.println(father.x);
    }
}

/**
 * 成员变量（非静态）的赋值过程：
 * 1.默认初始化 2.显示初始化/代码块中的初始化
 * 3.构造器中初始化 4有了对象之后，可以“对象。属性”或“对象。方法”的方式堆成员变量进行赋值
 */
class Father{
    int x = 10;

    public Father(){
        this.print();
        x=20;
    }

    public void print() {
        System.out.println("Father.x="+x);
    }
}

class Son extends Father{
    int x=30;
    public Son(){
        this.print();
        x=40;
    }

    public void print() {
        System.out.println("Son.x="+x);
    }
}
