package com.string;

/**
 *    new String("ab");会创建几个对象，看字节码，就知道是两个
 *    一个对象是:new关键字在堆空间创建的
 *    另一个对象是:字符串常量池中的对象。字节码指令: ldc
 *
 *    new String("a")+new String("b");
 *      对象1 : new stringBuilder()
 *      对象2: new string( "a")
 *      对象3:常量池中的"a"
 *      对象4:new string( "b")
 *      对象5:常量池中的""b"
 *
 *
 *    深入剖析: stringBuilder的tostring( ):
 *      对象6 : new string ( "ab")
 *      强调一下, tostring()的调用，在字符串常量池中，没有生成"ab"
 */
public class StringTest9 {
    public static void main(String[] args) {

    }
}
