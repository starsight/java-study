package com.wenjiehe.JavaSE;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;


/**
 * Created by yiyuan on 2016/9/24.
 */
public class JavaSE implements Cloneable {

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
        //super.clone();
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

    public static void main(String args[]) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, CloneNotSupportedException {
        /*A a1 = new A();
        A a2 = new B();
        //((B)a2).xx();
        B b = new B();
        System.out.println(a1.show(a2));
        System.out.println(a2.show(a1));
        System.out.println(b.show(a2));
        //((Test)m).i =0;


        A[] mm = new A[2];
        mm[0] = new B();
        System.out.println(mm[0].show(mm[0]));*/
        /*Test cc =new Test();
        JavaSE js = cc;
        js=new JavaSE();
        System.out.println(cc.i);*/

        /*String s1 = "nihao";
        String s2 = "nihao";
        String s3 = new String("nihao");
        System.out.println(s1.equals(s2));    //    true
        System.out.println(s1.equals(s3));    //    false
*/

        ArrayList<A> al = new ArrayList();
        // ((ArrayList<JavaSE>)b.arr()).get(0).replaceSpace(""));
        //al.get(0).show(new A());
       /* Integer it = 4;
        System.out.println(it.intValue());
        System.out.println(it.longValue());
        //System.out.println(it.s);



        JavaSE jse = new JavaSE();
        System.out.println(jse.xiaochengxu);
        xiaochengxu(jse);
        System.out.println(jse.xiaochengxu);*/
/*
        String str1 = "3";
        Integer it = Integer.parseInt(str1);
        String str2 = it.toString();
        if (str2.equals(str1))
            System.out.println("yes");

        String str3 = "33";
        String str4 = Integer.toString(33);
        if (str4 == str3)
            System.out.println("yes2");
        System.out.println(str4);
        String str5 = str4;
        if (str3 == str5)
            System.out.println("yes3");

        Class cl = Class.forName("com.wenjiehe.JavaSE.Test");
        //Method[] m = cl.getDeclaredMethods();
        Method[] m = cl.getMethods();
        for (Method cc : m)
            System.out.println(Modifier.toString(cc.getModifiers()) + cc.getName());

        //Field f = cl.getField("i");
        Test te = new Test();
        Class cl2 = (te).getClass();
        Field f = cl2.getDeclaredField("i");
        te.show();
        f.setAccessible(true);
        Object v = f.get(te);
        System.out.println(v);


        Test test = new Test();
        test.xiaochengxu = 99;
        Test test2 = test.clone();
        test2.xiaochengxu = 98;
        System.out.println(test.xiaochengxu);
        System.out.println(test2.xiaochengxu);
        int i = 9;
        test.cc(i);

        final int w;
        //w=9;
        w=89;
        System.out.println(w);


        //ArrayList<Test> arraytest  = new ArrayList<>();
         //ArrayList<JavaSE> arrayjavase = arraytest;
        //arrayjavase.add(new Test());
        //编译器不允许

       // Pair<Test> pair1 = new Pair<>();
       // Pair<JavaSE> pair2 = pair1;



        Pair<? super Manager> pair = new Pair<Employee>(null, null);
        minMaxSal(new Manager[] {new Manager("",9), new Manager("",8)}, pair);*/


        List<String> a = new LinkedList<>();
        a.add("a1");
        a.add("a2");
        a.add("a3");

        List<String> b = new LinkedList<>();
        b.add("b1");
        b.add("b2");
        b.add("b3");

        ListIterator listIteratorA = a.listIterator();
        Iterator IteratorB = b.iterator();

        while (IteratorB.hasNext()) {
            String mc = (String) IteratorB.next();
            System.out.println(mc);
            if (listIteratorA.hasNext())
                listIteratorA.next();
            listIteratorA.add(mc);
        }

        //listIteratorA.remove();
        //listIteratorA.remove();

        //System.out.println(a);
        LinkedList<String> ll = new LinkedList<>();
        ll.add("11");
        ll.add("22");
        ll.add("33");
        ListIterator<String> li = (ListIterator<String>) ll.iterator();
        li.next();
        li.add("44");
        while (li.hasNext()) {
            System.out.println(li.next());
            System.out.println("no next");
        }
        for (String s : ll)
            System.out.println(s);
        System.out.println();
        ArrayList<String> all = new ArrayList();
        all.add("11");
        all.add("22");
        all.add("33");
        all.add("44");
        //all.subList(0,3).clear();
        String[] values = all.toArray(new String[0]);
        Iterator<String> iterat = all.iterator();
        while (iterat.hasNext())
            System.out.println(iterat.next());
        System.out.println(Integer.MAX_VALUE);
        for(String s:values)
            System.out.println(s);

        System.out.println(sieve(100));
        System.out.println("over");
    }

    public int xiaochengxu = 0;

    static void xiaochengxu(JavaSE javase) {
        Test t = new Test();
        //javase = new JavaSE();
        javase.xiaochengxu = 99;
        System.out.println(javase.xiaochengxu);

    }

    static final int yu = 0;

    public void cc(final int i) {
        this.new m();
        //JavaSE.this.date = new Date();
        //InterfaceTest.o=9;
        //InterfaceTest.r = new JavaSE();
        //yu=0;
//InterfaceTest.o=9;
    }

    Date date = new Date();

    @Override
    protected JavaSE clone() throws CloneNotSupportedException {
        return (JavaSE) super.clone();
    }

    public static  int sieve(int max){
    BitSet bitSet = new BitSet(max+1);
        int count =0;
        int i=0;
        for(i=2;i<=max;i++)
            bitSet.set(i);

        i=2;
        while(i*i<=max){//对称
            if(bitSet.get(i)){
                count++;
                int k = 2*i;
                while(k<=max){
                    bitSet.clear(k);
                    k+=i;
                }
            }
            i++;
        }

        while(i<=max){
            if(bitSet.get(i))
                count++;
            i++;
        }
        return count;
    }

    public static void minMaxSal(Manager[] mgrs, Pair<? super Manager> pair) {
        if (mgrs == null || mgrs.length == 0) {
            return;
        }

        pair.setFirst(mgrs[0]);
        pair.setSecond(mgrs[0]);
    }
}

