package com.wenjiehe.NowCoder;

public class Huawei03 {
    public static void main(String[] args){
        String a="1234";
        String b="4321";
        String c=test1(a.toCharArray(),b.toCharArray());
        System.out.println(c);
    }
    public static String test1(char[] k, char[] l) {
        String out = ""; // 保存每一行相加后的结果
        int j = 0; // 控制错位
        for (int i = l.length - 1; i >= 0; i--) {
            out = test3(out.toCharArray(), test2(k, l[i]).toCharArray(), j++);
        }
        while (true)
        {
            char ch=out.charAt(0);
            if(ch=='0')
            {
                out=out.substring(1,out.length());
            }
            else
            {
                break;
            }
        }
        return out;
    }
    public static String test2(char[] k1, char k2) {
        int p = 0;
        String out = "";
        for (int j = k1.length - 1; j >= 0; j--) {
            int temp = k1[j] - '0';
            int tempb = k2 - '0';
            int sum = temp * tempb + p;
            p = sum / 10;
            int left = sum % 10;
            out += left;
        }
        if (p != 0)
            out += p;

        char[] sb = out.toCharArray();
        String value = "";
        for (int j = sb.length - 1; j >= 0; j--)
            value += sb[j];
        return value;
    }
    public static String test3(char[] k2, char[] l3, int l) {
        int maxlen = k2.length + l3.length;
        char[] revA = test4(k2);
        char[] revB = test4(l3);
        String sb = "";
        int a = 0;
        int b = 0;
        int p = 0;
        for (int i = 0; i < maxlen; i++) {
            a = 0;
            b = 0;
            if (i < revA.length)
                a = revA[i] - '0';
            // 第二行要先以为len的距离 ,错位相加
            if (i < revB.length + l && i >= l)
                b = revB[i - l] - '0';

            int sum = a + b + p;
            p = sum / 10;

            int left = sum % 10;
            sb += left;
        }
        while (p != 0) {
            sb += p % 10;
            p /= 10;
        }
        char[] result = sb.toCharArray();
        String value = "";
        for (int j = result.length - 1; j >= 0; j--)
            value += result[j];
        return value;
    }
    public static char[] test4(char[] h) {
        char[] p = new char[h.length];

        int i = 0;
        int j = p.length - 1;
        for (; j >= 0; j--) {
            p[i] = h[j];
            i++;
        }
        return p;
    }
}
