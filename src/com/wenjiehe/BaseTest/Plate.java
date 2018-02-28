package com.wenjiehe.BaseTest;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/2/27.
 */
public class Plate<T>{
    private T item;
    public Plate(T t){item=t;}
    public void set(T t){item=t;}
    public T get(){return item;}

    public static void main(String[] args) {

        Plate<? super Fruit> p=new Plate<Fruit>(new Fruit());

        add(p);
        //读取出来的东西只能存放在Object类里。

        Object newFruit2=p.get();

        if(newFruit2 instanceof Fruit){
            System.out.println("----");
        }

        ArrayList<? super Fruit> list = new ArrayList<>();
        add2(list);
        int a=-1,b=3;
        if((a>0)&(b<4)){

        }
    }

    public static void add2(ArrayList<? super Fruit> p) {
        //存入元素正常
        p.add(new Apple());
    }

    public static void add(Plate<? super Fruit> p) {
        //存入元素正常
        p.set(new Fruit());
        p.set(new Apple());
        p.set(new Banana());
    }
}

//Lev 1
class Food{}

//Lev 2
class Fruit extends Food{}
class Meat extends Food{}

//Lev 3
class Apple extends Fruit{}
class Banana extends Fruit{}
class Pork extends Meat{}
class Beef extends Meat{}

//Lev 4
class RedApple extends Apple{}
class GreenApple extends Apple{}