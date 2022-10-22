package com.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;

public class ExceptionTest08 {

    //抛出异常指令
    public void throwZero(int i){
        if(i==0){
            throw new RuntimeException("参数值为0");
        }
    }

    public void throwOne(int i) throws RuntimeException{
        if(i==1){
            throw new RuntimeException("参数值为1");
        }
    }

    public void throwArtithmetic(){
       int i=10;
       int j=i/0;
        System.out.println(j);
    }

    //异常表
    public void tryCatch(){
        try{
            File file = new File("d:/hello.txt");
            FileInputStream fis = new FileInputStream(file);
            String info ="hello";
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    //思考：如下方法返回结果为多少？
    public static String func(){
        String str = "hello";
        try{
            return str;
        }finally {
            str="atguigu";
        }
    }

    public static void main(String[] args) {
        System.out.println(func());
    }

}
