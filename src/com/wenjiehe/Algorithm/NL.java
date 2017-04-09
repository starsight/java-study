package com.wenjiehe.Algorithm;

import java.util.Scanner;
/**
 * Created by wenjie on 17/03/07.
 */
public class NL {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;

        if (in.hasNextInt()) {//注意while处理多个case
            a = in.nextInt();
            b = in.nextInt();
        }

        boolean isContin =true;
        int btemp = b;
        boolean isremove =false;
        while (isContin) {
            if(b>=100){
                System.out.print("No");
                return;
            }
            int cout = ++b;
            cout--;
            int middle = a / (cout);
            int count = (cout - 1) / 2;//循环次数
            int[] cc = new int[count * 2 + 1];
            int sum = middle;
            cc[count] = middle;
            for (int i = 1; i <= count; i++) {
                sum += 2 * middle;
                cc[count + i] = middle + i;
                cc[count - i] = middle - i;
            }

            int gap = a - sum;
            StringBuilder sb = new StringBuilder();

            if(cc[0]==0){
                if(cout>btemp)
                    isremove = true;
            }

            for (int i = 0; i < cc.length; i++) {
                if(isremove == true){
                    isremove = false;
                    continue;
                }
                if (i == cc.length - 1)
                    sb.append(cc[i]);
                else
                    sb.append(cc[i] + " ");
            }

            if(cc[0]<0){
                System.out.print("No");
                return;
            }


            if(gap==0){
                System.out.print(sb.toString());
                return;
            }else if(gap<0){
                System.out.print("No");
                return;
            }



            if (gap - cc[cc.length - 1] == 1) {
                sb.append(" "+gap);
                System.out.print(sb.toString());
                return;
            }

            if ((cc[0] - gap == 1)) {
                System.out.print(gap + " " + sb.toString());
                return;
            }


        }
        System.out.print("No");
    }
}
