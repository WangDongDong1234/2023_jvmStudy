package com.command;

public class LoadAndStoreTest01 {

    //1. 局部变量压栈指令
    public void load(int num,Object obj,long count,boolean flag,short[] arr){
        System.out.println(num);
        System.out.println(obj);
        System.out.println(count);
        System.out.println(flag);
        System.out.println(arr);
    }

    // 2.常量入栈指令
    public void pushConstLdc(){
        int a=5;
        int b=6;
        int c =127;
        int d =128;
        int e  = 1234567;
    }

    //3.出栈装入局部变量表指令
    public void store(int k,double d){
        int m = k+2;
        long l=12;
        String str ="atguigu";
        float f = 10.0F;
        d=10;
    }

    public void foo(long l,float f){
        {
            int i=0;
        }
        {
            String s ="hellw,World";
        }
    }

}
