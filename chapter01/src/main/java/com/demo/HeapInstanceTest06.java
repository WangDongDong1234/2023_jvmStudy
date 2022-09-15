package com.demo;

import java.util.ArrayList;
import java.util.Random;

/**
 * 持续往list里加内存，观看堆内存变化
 */
public class HeapInstanceTest06 {

    byte[] buffer = new byte[new Random().nextInt(1024*200)];

    public static void main(String[] args) {
        ArrayList<HeapInstanceTest06> list = new ArrayList<>();
        while (true){
            list.add(new HeapInstanceTest06());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
