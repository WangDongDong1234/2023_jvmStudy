package com.classloader.demo2;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader2 extends ClassLoader{

    private String byteCodePath;

    public MyClassLoader2(String byteCodePath) {
        this.byteCodePath = byteCodePath;
    }

    public MyClassLoader2(ClassLoader parent, String byteCodePath) {
        super(parent);
        this.byteCodePath = byteCodePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //获取字节码的完整路径
        String fileName =byteCodePath+name+".class";
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;

        try{
           bis = new BufferedInputStream(new FileInputStream(fileName));

           baos = new ByteArrayOutputStream();
            int len;
            byte[] data = new byte[1024];
            while ((len=bis.read(data))!=-1){
                baos.write(data,0,len);
            }
            //获取内存中的完整的字节数组的数据
            byte[] byteCodes =baos.toByteArray();
            //调用defineClass(),将字节数组中的数据转换为Class的实例
            Class clazz =defineClass(null,byteCodes,0,byteCodes.length);
            return clazz;
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(baos!=null){
                    baos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try{
                if(bis!=null){
                    baos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return null;

    }
}
