package com.gc;

/**
 * 测试object类中finalize()方法，即对象的finalization机制
 */
public class CanReliveObj02 {
    // 类变量,属于GC Root
    public static CanReliveObj02 obj;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类重写的finalize()方法");
        //当前待回收的对象在finalize()方法中与引用链上的一个对象obj建立了联系
        obj=this;//自救成功
    }

    public static void main(String[] args) throws InterruptedException {
        obj = new CanReliveObj02();
        obj=null;
        //调用垃圾回收器，执行对象的finalize方法
        System.gc();
        System.out.println("第一次GC");
        // 因为Finalizer线程优先级很低，暂停2S，以等待它
        Thread.sleep(2000);
        if(obj==null){
            System.out.println("obj is dead");
        }else{
            System.out.println("obj is still alive");
        }
        System.out.println("第二次GC");
        obj=null;
        //调用垃圾回收器，但是该对象的finalize方法不会被再次调用，对象会直接变成不可触及的状态
        System.gc();
        // 因为Finalizer线程优先级很低，暂停2S，以等待它
        Thread.sleep(2000);
        if(obj==null){
            System.out.println("obj is dead");
        }else{
            System.out.println("obj is still alive");
        }
    }
}
