package com.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReference09 {
    //当前类对象的声明
    public static PhantomReference09 obj;
    //引用队列
    static ReferenceQueue<PhantomReference09> phantomQueue = null;

    public static class CheckRefQueue extends Thread{
        @Override
        public void run() {
           while (true){
               if(phantomQueue!=null){
                    PhantomReference<PhantomReference09> objt =null;
                    try{
                        //从引用对列中去除虚引用
                        objt = (PhantomReference<PhantomReference09>) phantomQueue.remove();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    if(objt!=null){
                        System.out.println("追踪垃圾回收过程：PhantomReference09实例被GC了");
                    }
               }
           }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类的finalize()方法");
        obj = this;
    }

    public static void main(String[] args) {
        Thread t = new CheckRefQueue();
        //设置为守护线程，当程序中没有非守护线程时，守护线程结束结束
        t.setDaemon(true);
        t.start();

        phantomQueue = new ReferenceQueue<PhantomReference09>();
        obj = new PhantomReference09();
        //构造了PhantomReferenceTest09 对象的虚引用，并指定了引用队列
        PhantomReference<PhantomReference09> phantomReference = new PhantomReference<>(obj,phantomQueue);
        try{
            // 不可获取虚引用中的对象,此处返回是null
            System.out.println(phantomReference.get());
            // 将强引用去除
            obj =null;
            // 第一次进行GC,由于对象可复活，GC无法回收该对象
            System.out.println("第一次GC");
            System.gc();

            Thread.sleep(1000);

            if(obj == null){
                System.out.println("obj is null");
            }else {
                System.out.println("obj is not null");
            }
            System.out.println("第二次GC");
            obj = null;
            System.gc();//一旦将obj对象回收，就会将此虚引用存放到引用对列中
            Thread.sleep(1000);

            if(obj == null){
                System.out.println("obj is null");
            }else {
                System.out.println("obj is not null");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
