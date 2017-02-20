package com.wenjiehe.JavaSE;

import java.io.*;

import static com.wenjiehe.JavaSE.InterfaceTest.o;

/**
 * Created by yiyuan on 16/11/16.
 */
public class Stream {


    public Stream() {

    }

    public static void main(String[] args){
        FileInputStream in;
        try {
            //in = new FileInputStream("java-study.iml");
//            while(in.read())
            PrintWriter pw = new PrintWriter("a.txt");
            pw.print("222444");
            pw.println();
            pw.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("b.txt"));
            oos.writeObject(new Employee("hewenjie",10000));
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Employee ee = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("b.txt"));
            try {
                ee = (Employee)ois.readObject();
                ois.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(ee);


        //FileInputStream fiis = new FileInputStream("shuruyiduanhua");
        FileReader fr = null;
        try {
            fr = new FileReader("a.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        char[] cc = new char[50];
        int num = 0;
        try {
            while((num=fr.read(cc))!=-1){
                System.out.println(cc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] ca =new char[]{'t', 't'};
        char c='t';
        chuan('t');
        chuanarray(ca);
        System.out.println(c);
        System.out.println(ca[0]);

    }

    public static void chuan(char c){
        System.out.println("chuan:"+ c);
        c = 'a';
        System.out.println("chuan:"+ c);

    }
    public static void chuanarray(char[] c){
        System.out.println("chuan:"+ c[0]);
        c[0] = 'a';
        System.out.println("chuan:"+ c[0]);

    }
}
