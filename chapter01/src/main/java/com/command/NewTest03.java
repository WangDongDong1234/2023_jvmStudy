package com.command;

import java.io.File;

/**
 * 对象数组创建与访问指令
 */
public class NewTest03 {

    //1.创建指令
    public void newInstance(){
        Object obj = new Object();
        File file = new File("File");
    }

    public void newArray(){
        int[] intArray = new int[10];
        Object[] objArray = new Object[10];
        int[][] mintArray = new int[10][10];
        String[][] strArray = new String[10][];
    }

    //2.字段访问指令
    public void sayHello(){
        System.out.println("hello");
    }

    public void setOrderId(){
        Order order = new Order();
        order.id=1001;
        System.out.println(order.id);

        order.name="ORDER";
        System.out.println(order.name);
    }

    //3.数组操作指令
    public void setArray(){
        int[] intArray = new  int[10];
        intArray[3]=20;
        System.out.println(intArray[1]);
    }

    public void arrLength(){
        double[] arr = new double[10];
        System.out.println(arr.length);
    }

    //4.类型检查指令
    public String checkCast(Object obj){
        if(obj instanceof String){
            return (String)obj;
        }else{
            return null;
        }
    }
}

class Order {
    int id;
    static String name;

}
