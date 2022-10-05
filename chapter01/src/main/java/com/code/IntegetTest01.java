package com.code;

public class IntegetTest01 {

    public static void main(String[] args) {
        /**
         * 正常引用的地址和值是不可以比的，但是有自动拆箱和封箱
         */
        Integer x =5;
        int y=5;
        System.out.println(x==y);// true

        /**
         * 值如果在 range [-128, 127]  返回的是缓存中的所以相等
         */
        Integer i1= 10;
        Integer i2= 10;
        System.out.println(i1==i2);//true

        /**
         * 值如果不在 range [-128, 127]  则新new一个
         */
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3==i4);//false
    }
}
