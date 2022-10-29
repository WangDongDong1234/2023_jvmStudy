package com.command2;

import java.io.*;

/**
 * 类的主动使用：当创建一个类的实例时，比如使用new关键字，或者通过反射，克隆，反序列化
 */
public class ActiveUse1 {

    public static void main(String[] args) {
//        test1();
//        test2_A();
//        test2_B();
        test3();
    }

    /**
     * new关键字
     */
    public static void test1(){
        Order order = new Order();
    }

    /**
     * 序列化
     */
    public static void test2_A(){
        ObjectOutputStream oos =null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream("Order.dat"));
            oos.writeObject(new Order());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(oos!=null){
                    oos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    /**
     * 反序列化
     */
    public static void test2_B(){
        ObjectInputStream ois =null;
        try{
            ois = new ObjectInputStream(new FileInputStream("Order.dat"));
            Order order = (Order) ois.readObject();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(ois!=null){
                    ois.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    /**
     * 调用类的静态方法
     */
    public static void test3(){
        Order.method();
    }
}

class Order implements Serializable {
    static {
        System.out.println("Order类的初始化过程");
    }

    public  static void method(){
        System.out.println("Order method()....");
    }
}
