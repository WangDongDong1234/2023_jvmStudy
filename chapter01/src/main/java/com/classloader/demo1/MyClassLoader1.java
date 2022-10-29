package com.classloader.demo1;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 自定义类加载器，实现热替换,代码不全
 */
public class MyClassLoader1 extends ClassLoader{

    private String rootDir;

    public MyClassLoader1(String rootDir){
        this.rootDir = rootDir;
    }

    protected Class<?> findClass(String className) throws ClassNotFoundException{
        //获取字节码的完整路径
        String fileName =rootDir;
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
