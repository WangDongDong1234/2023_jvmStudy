package com.jconsole;


import java.util.ArrayList;
import java.util.Random;

/**
 * -Xms600m -Xmx600m -XX:SurvivorRatio=8
 */
public class HeapInstanceTest01 {

    byte[] buffer = new byte[new Random().nextInt(1024*100)];
    public static void main(String[] args) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<HeapInstanceTest01> list = new ArrayList<>();
        while (true){
            list.add(new HeapInstanceTest01());

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}