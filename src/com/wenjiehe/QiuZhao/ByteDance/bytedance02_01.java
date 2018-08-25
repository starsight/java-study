package com.wenjiehe.QiuZhao.ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bytedance02_01 {
    //0% by dingjianwei
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        Map<Integer, Boolean> mark = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        int m = n;
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] sarr = s.split(" ");
            int len = sarr.length;
            for (int j = 0; j < sarr.length; j++) {

                a.add(Integer.valueOf(sarr[j]));
            }
            map.put(i, new ArrayList<Integer>(a));
        }
        for (int i = 0; i < mark.size(); i++) {
            if (mark.get(i) == true) {
                m--;
            }
        }
        System.out.println(m);
    }


    public void DFS(Map<Integer, ArrayList<Integer>> map, Map<Integer, Boolean> mark) {

        for (Integer num : map.keySet()) {
            mark.put(num, false);
        }

        for (int i = 0; i < map.size(); i++) {
            ArrayList<Integer> arr = map.get(i);
            for (int k = 0; k < arr.size(); k++) {
                int start = arr.get(k);
                DFS2(map, mark, start);
            }
        }


    }

    public static void DFS2(Map<Integer, ArrayList<Integer>> map, Map<Integer, Boolean> mark, int start) {
        mark.put(start, true);
        for (int y = 0; y < map.get(start).size(); y++) {
            int num2 = map.get(start).get(y);
            if (!mark.get(num2)) {
                int num3 = num2;
                DFS2(map, mark, num3);
            }
        }

    }

}
