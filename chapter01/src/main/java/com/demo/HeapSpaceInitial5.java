package com.demo;

public class HeapSpaceInitial5 {

    public static void main(String[] args) throws InterruptedException {

        //返回java虚拟机中的堆内存总量
        long initialMemory =Runtime.getRuntime().totalMemory()/1024/1024;

        // 返回Java虚拟机试图使用的最大堆内存两
        long maxMemory = Runtime.getRuntime().maxMemory()/1024/1024;

        System.out.println("-Xms: "+initialMemory+"M");
        System.out.println("-Xmx: "+maxMemory+"M");

        Thread.sleep(10000000);

    }
}
