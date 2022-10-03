package com.gc;

import java.lang.ref.WeakReference;

/**
 * 弱引用代码尝试
 */
public class WeakReference08 {
    public static void main(String[] args) {
        //构造了弱引用
        WeakReference<Student> studentWeakReference = new WeakReference<>(new Student(1,"王冬冬"));
        //从弱引用中重新获取对象
        System.out.println(studentWeakReference.get());

        System.gc();
        //不管当前内存空间足够与否，都会回收内存
        System.out.println("After GC：");
        //重新从弱引用中重新获取对象
        System.out.println(studentWeakReference.get());

    }
}
