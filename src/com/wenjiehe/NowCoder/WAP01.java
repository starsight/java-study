package com.wenjiehe.NowCoder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class WAP01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int [][] routes = new int[m][];

        for (int i = 0; i < m; i++) {
            int k = in.nextInt();
            int[] S = new int[k];
            for (int j = 0; j < k; j++) {
                int x = in.nextInt();
                S[j] =x;
            }
            routes[i] =S;
        }

        int result = 0;

        result = numBusesToDestination(routes,1,n);

        System.out.println(result);

    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int j : routes[i]) {
                if (!map.containsKey(j)) map.put(j, new HashSet<Integer>());
                map.get(j).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int next : map.get(S)) {
            visited.add(next);
            queue.add(next);
        }
        int res = 1;
        while (!queue.isEmpty()) {
            Queue<Integer> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int c : routes[cur]) {
                    if (c == T) return res;
                    for (int next : map.get(c)) {
                        if (!visited.contains(next)) {
                            tmp.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            ++res;
            queue = tmp;
        }
        return -1;
    }

}
