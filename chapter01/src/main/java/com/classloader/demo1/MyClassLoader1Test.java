package com.classloader.demo1;


import java.lang.reflect.Method;

public class MyClassLoader1Test {

    public static void main(String[] args) {
        while (true){
            try{
                MyClassLoader1 loader1 = new MyClassLoader1("D:\\2023\\2023_jvmStudy\\chapter01\\src\\main\\java\\com\\classloader\\");
                Class clazz =loader1.findClass("com.classloader.Demo");
                Object demo =clazz.newInstance();
                Method m =clazz.getMethod("hot");
                m.invoke(demo);
                Thread.sleep(5000);
            }catch (Exception e){
                System.out.println("not found");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }
}
