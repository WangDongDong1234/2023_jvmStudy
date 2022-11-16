package com.jprofiler;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class JprofilerTest02 {
    public static void main(String[] args) {
        while (true){
            ArrayList list= new ArrayList();
            for(int i=0;i<500;i++){
                Data data = new Data();
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

class Data{
    private int size=10;
    private byte[] buffer = new byte[1024*1024];//1mb
    private String info ="hello,atguigu";
}
