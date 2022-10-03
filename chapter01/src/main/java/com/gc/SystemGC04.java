package com.gc;

public class SystemGC04 {
    public static void main(String[] args) {
        new SystemGC04();
        // 提醒JVM的垃圾回收器执行gc,但是不确定是否马上执行
        System.gc();  // Runtime.getRuntime().gc();

        //强制调用使用引用对象的finalize()方法
        System.runFinalization();

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("SystemGCTest 重写了finalize（）");
    }
}
