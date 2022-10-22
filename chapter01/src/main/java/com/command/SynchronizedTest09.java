package com.command;

/**
 * 同步控制指令
 */
public class SynchronizedTest09 {
    private int i=0;
    public synchronized void add(){
        i++;
    }

    private Object object = new Object();
    public void substract(){
        synchronized (object){
            i--;
        }
    }
}
