package com.string;

/**
 * String的垃圾回收
 * -Xms15m -Xmx15m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails
 */
public class StringTest14 {
    public static void main(String[] args) {
        for(int i =0;i<100000;i++){
            String.valueOf(i).intern();
        }
    }
}
