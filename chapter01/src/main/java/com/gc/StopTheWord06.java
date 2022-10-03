package com.gc;

import java.util.ArrayList;
import java.util.List;

public class StopTheWord06 {

    public static class WorkThread extends Thread{
        List<byte[]> list =new ArrayList<>();

        public void run(){
            while (true){
                for(int i=0;i<1000;i++){
                    byte[] buffer = new byte[1024];
                    list.add(buffer);
                }
                if(list.size()>10000){
                    list.clear();
                    System.gc();// 会触发full gC,进而会出现STW事件
                }
            }
        }
    }

    public static class PrintThread extends Thread{
        public final long startTime =System.currentTimeMillis();
        public void run(){
            while (true){
                long t=System.currentTimeMillis()-startTime;
                System.out.println(t/1000+"."+t%1000);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        WorkThread workThread = new WorkThread();
        PrintThread printThread = new PrintThread();
        workThread.start();
        printThread.start();
    }
}

