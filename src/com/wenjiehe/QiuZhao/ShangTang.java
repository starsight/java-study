package com.wenjiehe.QiuZhao;

import java.util.Scanner;

public class ShangTang {
    static int lineX,lineY;//迷宫矩阵的长度和宽度
    static int startX,startY;//起始位置的坐标
    static String[][] arr;//迷宫的二维数组
    static int count=10000;//走的最少步数，初始值设置为10000意为无穷
    public static void main(String[] args){
        Input();//输入函数
        Running(startX,startY,0);//递归函数
        Output();//输出函数
    }
    public static void Input(){
        Scanner sc = new Scanner(System.in);
        lineX = Integer.parseInt(sc.next());//获取迷宫长宽
        lineY = Integer.parseInt(sc.next());
        arr = new String[lineX][lineY];//初始化迷宫数组
        for(int i=0;i<lineX;i++){
            String str = sc.next();
            AddToArr(str,i);//将每一个符号放入二维数组
        }
    }
    public static void AddToArr(String str,int n){
        for(int i=0;i<lineY-1;i++){
            arr[n][i]=str.substring(i,i+1);
            setStart(str.substring(i,i+1),n,i);//寻找起始位置
        }
        arr[n][lineY-1]=str.substring(lineY-1);
        setStart(str.substring(lineY-1),n,lineY-1);
    }
    public static void setStart(String a,int x,int y){
        if(a.equals("S")){
            startX=x;
            startY=y;
        }
    }
    /************递归函数************/
    public static void Running(int x,int y,int n){
        //System.out.println(x+" "+y+" "+n);//打印每一步方便理解
        /*判断上下左右有没有终点*/
        if(y-1>=0&&arr[x][y-1].equals("G")){
            Running(x,y-1,n+1);
        }
        if(x-1>=0&&arr[x-1][y].equals("G")){
            Running(x-1,y,n+1);
        }
        if(y+1<lineY&&arr[x][y+1].equals("G")){
            Running(x,y+1,n+1);
        }
        if(x+1<lineX&&arr[x+1][y].equals("G")){
            Running(x+1,y,n+1);
        }
        /*如果是终点就将最短路径记录一下，然后退出此次函数*/
        if(arr[x][y].equals("G")){
            if(n<count)
                count=n;
            return;
        }
        arr[x][y]="*";//若非终点，将该点做个记号"*"表示已经走过，使以后不再走到这个位置
        /*判断上下左右有没有可以走的路*/
        if(y-1>=0&&arr[x][y-1].equals(".")){
            Running(x,y-1,n+1);
        }
        if(x-1>=0&&arr[x-1][y].equals(".")){
            Running(x-1,y,n+1);
        }
        if(y+1<lineY&&arr[x][y+1].equals(".")){
            Running(x,y+1,n+1);
        }
        if(x+1<lineX&&arr[x+1][y].equals(".")){
            Running(x+1,y,n+1);
        }
        //若没有可以走的路就将此处的记号取消，变回"."
        arr[x][y]=".";
        return;
    }
    public static void Output(){
        if(count==10000){
            System.out.println("没有出口！");
        }
        else{
            System.out.println("最少需要"+count+"步");
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[][] num = new int[N][M];
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                num[i][j] = sc.nextInt();
//            }
//        }
//        int[][] dp = new int[N][M];
//        for (int i = 1; i < M; i++) {
//            if (dp[0][i - 1] == -1) {
//                dp[0][i] = -1;
//                continue;
//            }
//
//            dp[0][i] = dp[0][i - 1] + num[0][i];
//        }
//        for (int i = 1; i < N; i++) {
//            if (num[i][0] == -1) {
//                dp[i][0] = -1;
//                continue;
//            }
//            dp[i][0] = dp[i - 1][0] + num[i][0];
//        }
//
//        for (int i = 1; i < N; i++) {
//            for (int j = 1; j < M; j++) {
//
//                if (num[i][j] == -1) {
//                    dp[i][j] = -1;
//                    continue;
//                }
//
//                if (dp[i - 1][j] == -1) {
//                    dp[i][j] = dp[i][j - 1];
//                } else if (dp[i][j - 1] == -1) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
//                }
//                dp[i][j] += num[i][j];
//
//            }
//        }
//
//        System.out.println(dp[N - 1][M - 1]);
//
//    }

}
