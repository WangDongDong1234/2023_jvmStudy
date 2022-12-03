package com.memoryleak;

import java.util.HashSet;

/**
 * 演示内存泄漏
 */
public class ChangeHashCode01 {
    public static void main(String[] args) {
        HashSet<Point> hs = new HashSet<>();
        Point cc =new Point();
        cc.setX(10); //hashCode =41
        hs.add(cc);
        cc.setX(20); //hashCode =51
        System.out.println("hs.remove =" +hs.remove(cc));//移除失败，因为根据cc新的值未计算出原来的hashCode
        hs.add(cc);
        System.out.println("hs.size ="+hs.size()); //size =2
    }
}

class Point{
    int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int hashCode() {
      final int prime =31;
      int result =1;
      result = prime*result+x;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this ==obj) return  true;
        if(obj == null) return  false;
        if(getClass()!=obj.getClass()) return  false;
        Point other =( Point)obj;
        if(x!=other.x) return false;
        return true;
    }
}
