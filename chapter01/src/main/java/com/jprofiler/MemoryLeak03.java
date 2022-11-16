package com.jprofiler;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MemoryLeak03 {
    public static void main(String[] args) {
        while (true){
            ArrayList list = new ArrayList();
            for(int i=0;i<500;i++){
                Bean data = new Bean();
                data.list.add(new byte[1024*10]);//10kb
                list.add(data);
            }

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Bean{
    int size=10;
    String info ="hello.atguigu";
    static ArrayList list = new ArrayList();

    //非静态才会随着对象的销毁而销毁
    //ArrayList list = new ArrayList();
}
