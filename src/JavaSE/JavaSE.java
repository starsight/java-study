package JavaSE;

import DesignModel.MallDuck;

import java.util.Scanner;


/**
 * Created by yiyuan on 2016/9/24.
 */
public class JavaSE {

    JavaSE(){

    }

    public static void main(String args[]) {
        // System.out.println("what's your name?");
        //Scanner sc = new Scanner(System.in);
        //System.out.println(sc.nextLine());

//        double[][] dd = new double[2][2];
//        dd[0][0] = 0.03;
//        for (double[] d : dd)
//            for (double ddd : d)
//                ddd = 3.3;

//StringBuffer sb = new StringBuffer();


        Test t = new Test();
        int m=0;
        change(t);
        System.out.println(t.i);

    }

    public static void change(Test t){
        t.i=22;
        System.out.println(t.i);
    }

}
