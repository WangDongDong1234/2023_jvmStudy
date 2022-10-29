package com.classloader.demo2;

public class MyClassLoader2Test {
    public static void main(String[] args) {
        MyClassLoader2 loader2 = new MyClassLoader2("D:\\2023\\2023_jvmStudy\\chapter01\\src\\main\\java\\com\\classloader\\");

        try {
            Class clazz =loader2.loadClass("Demo");
            System.out.println("加载此类的类加载器为："+clazz.getClassLoader() .getClass() .getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
