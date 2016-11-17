package com.wenjiehe.JavaSE;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yiyuan on 2016/9/28.
 */
public class Pair<T> {
    public T first;
    public T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}

class Employee implements Serializable{
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public Manager(String n, double s) {
        super(n, s);
    }
}

class President extends Manager {
    public President(String n, double s) {
        super(n, s);
    }
}




