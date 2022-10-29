package com.command2;

/**
 *
 * 关于类的被动使用，即不会进行类的初始化操作，即不会调用<clinit>()*
 * 1．当访问一个静态字段时，只有真正声明这个字段的类才会被初始化。
 *      >当通过子类引用父类的静态变量，不会导致子类初始化
 * 2. 通过数组定义类引用,不会触发此类的初始化,对数组中单个元素new时候会初始化
 * 3．引用常量不会触发此类或接口的初始化。因为常量在链接阶段就已经被显式赋值了。
 * 4．调用cLassLoader类的LoadCLass()方法加载一个类，并不是对类的主动使用，不会导致类的
 *       Class.forName("com.command2.Order") 这个是主动使用，注意区别
 *
 * 说明:没有初始化的类，不意味着没有加载!
 * */
public class PassiveUse1 {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 1．当访问一个静态字段时，只有真正声明这个字段的类才会被初始化。
     *    >当通过子类引用父类的静态变量，不会导致子类初始化
     */
    public static void test1() {
        System.out.println(Child.num);
    }

    /**
     * 2.通过数组定义类引用,不会触发此类的初始化,对数组中单个元素new时候会初始化
     */
    public static void test2() {
       Parent[] parents = new Parent[10];
       parents[1] = new Parent();
    }
}


class Parent{
    static {
        System.out.println("Parent的初始化过程");
    }

    public static int num = 1;
}

class Child extends Parent{
    static {
        System.out.println("Child的初始化过程");
    }
}
