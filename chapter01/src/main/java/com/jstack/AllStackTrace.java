package com.jstack;

import java.util.Map;
import java.util.Set;

/**
 * 打印所有线程信息=jstack命令
 */
public class AllStackTrace {
    public static void main(String[] args) {
        //追踪当前进程中的所有线程
        Map<Thread,StackTraceElement[]> all =Thread.getAllStackTraces();
        Set<Map.Entry<Thread,StackTraceElement[]>> entries = all.entrySet();
        for(Map.Entry<Thread,StackTraceElement[]> em:entries){
            Thread t = em.getKey();
            StackTraceElement[] v =em.getValue();
            System.out.println("Thread name is:"+t.getName());
            for(StackTraceElement s:v){
                System.out.println("\t"+s.toString());
            }
        }
    }
}
