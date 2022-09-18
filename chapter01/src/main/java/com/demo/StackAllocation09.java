package com.demo;

/**
 * 栈上分配测试
 * -Xmx1G -Xms1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails  耗时405ms   Java VisualVM 可以看到10000000个对象用例
 *
 * -Xmx1G -Xms1G -XX:+DoEscapeAnalysis -XX:+PrintGCDetails  耗时16ms   Java VisualVM 可以看到53467个对象用例
 *
 */
public class StackAllocation09 {

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();

        for(int i=0;i<10000000;i++){
            alloc();
        }

        long end =System.currentTimeMillis();

        System.out.println("花费时间为："+(end-start)+"ms");
        Thread.sleep(1000000);
    }

    private static void alloc() {
        User user = new User();
    }

    static class User{

    }
}
