package com.jmap;

import java.util.ArrayList;

/**
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8
 */
public class GCTest01 {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        for(int i=0;i<1000;i++){
            //100kb
            byte[] arr = new byte[1024*100];
            list.add(arr);


        }
    }
}
