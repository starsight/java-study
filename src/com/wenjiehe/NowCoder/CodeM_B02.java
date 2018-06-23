package com.wenjiehe.NowCoder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CodeM_B02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArray = str.split(" ");
        int n = Integer.valueOf(strArray[0]);
        int m = Integer.valueOf(strArray[1]);
        int k = Integer.valueOf(strArray[2]);
        Node[] allNode = new Node[n];
        for (int i = 0; i < n; i++) {
            str = sc.nextLine();
            strArray = str.split(" ");
            allNode[i] = new Node();
            allNode[i].node = Integer.valueOf(strArray[0]);
            allNode[i].date = new  GregorianCalendar();
            int[] arr = split(strArray[1]);
            int[] array = splitHelper(strArray[2]);
            allNode[i].date.set(arr[0],arr[1],arr[2],array[0],array[1],array[2]);
        }

        int index1,index2;


        V[][] map =new V[k+1][k+1];

        for (int i = 0; i <k+1 ; i++) {
            for (int j = 0; j < k+1 ; j++) {
                map[i][j] = new V();
                map[i][j].cost = Long.MAX_VALUE;
            }
        }

        for (int i = 0; i <m ; i++) {
            str = sc.nextLine();
            strArray = str.split(" ");
            index1 = Integer.valueOf(strArray[0]);
            index2 = Integer.valueOf(strArray[1]);
            map[index1][index2] = new V();
            map[index1][index2].from = new  GregorianCalendar();
            map[index1][index2].to = new  GregorianCalendar();

            int[] array = splitHelper(strArray[3]);
            int[] array2 = splitHelper(strArray[4]);

            map[index1][index2].from.set(2018,Calendar.JULY,1,array[0],array[1],array[2]);
            map[index1][index2].to.set(2018,Calendar.JULY,1,array2[0],array2[1],array2[2]);

            map[index1][index2].cost = Integer.valueOf(strArray[2]);
        }

        System.out.println(soultion(map,allNode));
    }

    public static int[] split(String str){
        int[] res = new int[3];
        String[] arr = str.split("\\.");
        res[0] = Integer.valueOf(arr[0]);
        res[1] = Integer.valueOf(arr[1]);
        res[2] = Integer.valueOf(arr[2]);
        return res;
    }

    public static int[] splitHelper(String str){
        String[] arr = str.split(":");
        int[] res = new int[3];
        res[0] = Integer.valueOf(arr[0]);
        res[1] = Integer.valueOf(arr[1]);
        res[2] = Integer.valueOf(arr[2].split("\\.")[0]);
        return res;
    }

    static class V{
        long cost;
        Calendar from;
        Calendar to;
    }

    static class Node{
        int node;
        Calendar date;
    }

    public static long soultion(V[][] map, Node[] allNode){
        int allCost =0;

        Node from = allNode[0];
        Node to ;

        for (int i = 1; i < allNode.length; i++) {
            to = allNode[i];
            allCost += soultionHelper(map,from,to);
            from = to;
        }

        return allCost;
    }

    public static long soultionHelper(V[][] map, Node from , Node to){
        int f = from.node;
        int t = to.node;
        long cost =0;
        int n = map.length;
        V[][] dist = new V[n][n];

        Calendar fromDate = from.date;
        Calendar toDate = to.date;

        for (int i=0; i<n; ++i) {
            for (int j = 0; j < n; ++j) {
                dist[i][j] = map[i][j];
            }
        }

        for (int i=1; i<n; ++i) {
            for (int j=1; j<n; ++j) {
                for (int k=1; k<n; ++k) {
                    if (dist[i][k].cost + dist[k][j].cost < dist[i][j].cost && check(dist,dist[i][j].from,dist[i][j].to,i,j,k)) {
                        dist[i][j].cost = dist[i][k].cost + dist[k][j].cost;

                    }
                }
            }
        }

        return dist[f][t].cost;
    }

    public static boolean check(V[][] dist,Calendar fromDate, Calendar toDate,int i,int j,int k){

        if(fromDate==null||toDate==null||dist[i][k].from==null||dist[i][k].to==null)
            return true;

        long f = convert(fromDate);
        if(f>convert(dist[i][k].from)){
            fromDate.add(Calendar.DAY_OF_MONTH, 1);
        }

        fromDate.set(Calendar.HOUR,dist[i][k].to.get(Calendar.HOUR));
        fromDate.set(Calendar.MINUTE,dist[i][k].to.get(Calendar.MINUTE));
        fromDate.set(Calendar.SECOND,dist[i][k].to.get(Calendar.SECOND));

        f = convert(fromDate);
        if(f>convert(dist[k][j].to)){
            fromDate.add(Calendar.DAY_OF_MONTH, 1);
        }

        fromDate.set(Calendar.HOUR,dist[k][j].to.get(Calendar.HOUR));
        fromDate.set(Calendar.MINUTE,dist[k][j].to.get(Calendar.MINUTE));
        fromDate.set(Calendar.SECOND,dist[k][j].to.get(Calendar.SECOND));

        if(fromDate.compareTo(toDate)>=0){
            return false;
        }

        return true;
    }

    public static long convert(Calendar dat){
        Date date = dat.getTime();
        int hour = date.getHours();
        int minute = date.getMinutes();
        int second = date.getSeconds();
        long time = hour*3600+minute*60+second;
        return time;
    }
}
