package com.gc;

import com.demo.ScalarReplace10;

import java.lang.ref.SoftReference;

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 * 软引用测试
 */
public class SoftReference07 {
    public static void main(String[] args) {
        SoftReference<Student> userSoftReference = new SoftReference<>(new Student(1,"王冬冬"));
//        // 上一行代码等于下面三行
//        Student u1 =new Student(1,"王冬冬");
//        SoftReference<Student> userSoftReference = new SoftReference<>(u1);
//        u1=null;

        //从软引用中从新获得强引用对象
        System.out.println(userSoftReference.get());

        System.gc();



        //垃圾回收之后获得软引用中的对象
        System.out.println("After GC"+userSoftReference.get());

        try{
            //设置堆大小为10M,让系统认为内存资源紧张
            byte[] b = new byte[1024*1024*7];
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            // 再次从软引用中获取数据，确实资源紧张，此处会为null
            System.out.println("资源紧张"+userSoftReference.get());
        }



    }
}



