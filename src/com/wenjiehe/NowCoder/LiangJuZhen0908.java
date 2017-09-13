package com.wenjiehe.NowCoder;

/**
 * Created by Administrator on 2017/9/8.
 */
public class LiangJuZhen0908 {
    public static void main(String[] args) {
        liangJuZhen("abracadabra");
    }

    public static String liangJuZhen(String input){
        int[] raw = new int[input.length()];
        int[] temp = new int[input.length()];

        for (int i = 0; i < input.length() ; i++) {
            raw[i]=input.charAt(i);
            temp[i]=input.charAt(i);
        }

        int start=-1;
        boolean isCom=false;

        for (int i = 1; i < input.length(); i++) {
            int x=i;
            int y=0;
            int count=0;
            while (raw[x]==temp[y]) {
                count++;
                if(x==input.length()-1) {
                    isCom = true;
                    break;
                }
                x++;
                y++;
            }
            if(isCom){
                int alone = input.length()-count;
                String str = input.substring(0,alone);
                str+=input;
                System.out.println(str);
            }
        }

        return "";
    }
    /*for (int j = 0; j < input.length(); j++) {
        int x=i;
        int y=j;
        int count=0;
        while(raw[x]==temp[y]){
            count++;
            if(x==input.length()-1) {
                isCom = true;
                break;
            }
            x++;
            y++;

        }
        if(isCom){
            System.out.println(count);

        }
    }*/
}
