package com.command2;

public class InitializationTest {
    public static int id =1;
    public static int number;

    static {
        number =2;
        System.out.println("father static{}");
    }
}
