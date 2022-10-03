package com.gc;

/**
 * 测试是否采用引用计数算法
 */
public class RefCountGC01 {

    //这个成员属性的唯一的作用就是占用一点内存
    private byte[] bigSize = new byte[5*1024*1024];

    Object reference =null;

    public static void main(String[] args) {
        RefCountGC01 obj1 = new RefCountGC01();
        RefCountGC01 obj2 = new RefCountGC01();

        obj1.reference = obj2;
        obj2.reference = obj1;

        obj1=null;
        obj2 =null;
        // 显式的执行垃圾回收行为
        // 这里发生GC,obj1和obj2能否被回收  答案是被回收
        System.gc();
    }
}
