package com.command2;

/**
 * 静态代码加载的死循环
 */
class StaticA{
    static{
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Class.forName("com.command2.StaticB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticA init OK");
    }
}

class StaticB{
    static{
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Class.forName("com.command2.StaticA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticB init OK");
    }
}

public class StaticDeadLockMain01 extends Thread{
    private char flag;
    public StaticDeadLockMain01(char flag){
        this.flag = flag;
        this.setName("Thread"+flag);
    }

    @Override
    public void run() {
        try{
            Class.forName("com.command2.Static"+flag);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StaticDeadLockMain01 loadA = new StaticDeadLockMain01('A');
        loadA.start();

        StaticDeadLockMain01 loadB = new StaticDeadLockMain01('B');
        loadB.start();
    }
}
