package com.gc;

public class LocalVarGC05 {

    public void localVarGC1() {
        byte[] buffer = new byte[10*1024*1024];
        System.gc();  //buffer不能被回收
    }

    public void localVarGC2() {
        byte[] buffer = new byte[10*1024*1024];
        buffer =null;
        System.gc();  //buffer能被回收
    }

    public void localVarGC3() {
        {
            byte[] buffer = new byte[10*1024*1024];
        }

        System.gc();  //buffer不能被回收
    }

    public void localVarGC4() {
        {
            byte[] buffer = new byte[10*1024*1024];
        }
        int value =10;  //buffer能被回收
        System.gc();
    }

    public void localVarGC5() {
       localVarGC1();
        System.gc(); // GC1中的buffer被回收了
    }

    public static void main(String[] args) {

    }
}
