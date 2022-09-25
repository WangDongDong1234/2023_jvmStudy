package com.string;

public class StringTest5 {

    public static void main(String[] args) {
        int i=1;
        Object obj = new Object();
        StringTest5 mem = new StringTest5();
        mem.foo(obj);
    }

    private void foo(Object obj) {
        String str = obj.toString();
        System.out.println(str);
    }
}
