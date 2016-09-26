package com.wenjiehe.JavaSE;


import java.util.ArrayList;

/**
 * Created by yiyuan on 2016/9/24.
 */
public  class JavaSE {

    {
        System.out.println("父类代码块");
    }

    static {
        System.out.println("父类静态代码块");
    }

    JavaSE(float i) {
        System.out.println("父类构造函数");
    }

    JavaSE(double p) {
        System.out.println("父类构造函数");
    }

    JavaSE(int i) {
        System.out.println("父类构造函数");
    }

    JavaSE(long p) {
        System.out.println("父类构造函数");
    }

    JavaSE(char p) {
        System.out.println("父类构造函数");
    }

    JavaSE() {
    }

    String replaceSpace(StringBuffer str) {
        System.out.println("replace");
        return "hello";
    }


    public class m {

    }


    public class mm {

    }

    static class A {

        protected int m = 0;

        public String show(A obj) {
            return ("A and A");
        }

        public String show(B obj) {
            return ("A and B");
        }
    }

    static class B extends A {
        //private int m =0;
        public String show(B obj) {
            return ("B and B");
        }

        public void xx() {
            //m=9;
        }

        public ArrayList arr() {
            return new ArrayList(1);
        }

        public String show(A obj) {
            return ("B and A");
        }
    }

    public static void main(String args[]) {
        A a1 = new A();
        A a2 = new B();
        //((B)a2).xx();
        B b = new B();
        System.out.println(a1.show(a2));
        System.out.println(a2.show(a1));
        System.out.println(b.show(a2));
        //((Test)m).i =0;


        A[] mm = new A[2];
        mm[0] = new B();
        System.out.println(mm[0].show(mm[0]));
        /*Test cc =new Test();
        JavaSE js = cc;
        js=new JavaSE();
        System.out.println(cc.i);*/

        String s1 = "nihao";
        String s2 = "nihao";
        String s3 = new String("nihao");
        System.out.println(s1.equals(s2));    //    true
        System.out.println(s1.equals(s3));    //    false


        ArrayList<A> al = new ArrayList();
       // ((ArrayList<JavaSE>)b.arr()).get(0).replaceSpace(""));
        //al.get(0).show(new A());
        Integer it = 4;
        System.out.println(it.intValue());
        System.out.println(it.longValue());
        //System.out.println(it.s);



        JavaSE jse = new JavaSE();
        System.out.println(jse.xiaochengxu);
        xiaochengxu(jse);
        System.out.println(jse.xiaochengxu);
    }

    int xiaochengxu=0;
    static void  xiaochengxu(JavaSE javase){
        //javase = new JavaSE();
        javase.xiaochengxu=99;
        System.out.println(javase.xiaochengxu);
    }
}

