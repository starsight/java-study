package com.wenjiehe.BaseTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/27.
 */
class Father {
    Fruit overw(){
        System.out.println("Father");
        return new Fruit();
    }
}
class Son extends Father{
    int a=0;
    void print(){
        System.out.println(a);
    }
    String overw(int i){
        System.out.println("Son");
        return "";
    }

}
class Son2 extends  Father{
    int a2=0;
    void print(){
        System.out.println(a2);
    }

}

class T{
    public static void main(String[] args) {
        T t = new T();
        ArrayList<? super Father> list = new ArrayList<>();
        t.add(list);
        t.get(list);

        ArrayList<String> str = new ArrayList<>();
        ArrayList<Integer> str2 = new ArrayList<>();
        if(list.getClass()==str2.getClass()){
            System.out.println("");
        }

        Integer i1 = 9;
        Integer i2 =new Integer(9);
        //System.out.println(i1==i2);
        int i3 =9;
        System.out.println(i1==i3);
        System.out.println(i1.equals(i3));
        System.out.println(i2.equals(i3));
        //System.out.println(i2==i1);
        double s =01212;

    }

    public  void add(ArrayList<? super Father> list ){
        Son s =new Son();
        s.a =1;
        list.add(s);

        Son2 s2 =new Son2();
        s2.a2=2;
        list.add(s2);
    }

    public  void get(ArrayList<? super Father> list ){
        Object ss = list.get(0);
        Object ss2 = list.get(1);


        System.out.println(ss.getClass());
        if(ss instanceof Son){
            ((Son)ss).print();
        }
        if(ss2 instanceof Son2){
            ((Son2)ss2).print();
        }

        byte b1=127,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b3=b4+b5;
        b3=(byte)(b1+b2);
        //System.out.println(b6);
    }
}

