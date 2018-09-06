package com.wenjiehe.QiuZhao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class MeiTuan {
    public static void main(String[] args) {
        MeiTuan meiTuan = new MeiTuan();
        meiTuan.bookGraph();
    }

    public void bookGraph() {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        N--;
        Graph graph = new Graph(N);
        Edge[] edges = new Edge[N];
        for (int i = 0; i < N; i++) {
            String[] str = sc.nextLine().split(" ");
            int f = Integer.valueOf(str[0]);
            int t = Integer.valueOf(str[1]);
            edges[i] = new Edge(f, t, 1);
        }
//        edges[0] = new Edge(0, 1, 4);
//        edges[1] = new Edge(0, 7, 8);
//        edges[2] = new Edge(1, 2, 8);
//        edges[3] = new Edge(1, 7, 11);
//        edges[4] = new Edge(2, 3, 7);
//        edges[5] = new Edge(2, 5, 4);
//        edges[6] = new Edge(2, 8, 2);
//        edges[7] = new Edge(3, 4, 9);
//        edges[8] = new Edge(3, 5, 14);
//        edges[9] = new Edge(4, 5, 10);
//        edges[10] = new Edge(5, 6, 2);
//        edges[11] = new Edge(6, 7, 1);
//        edges[12] = new Edge(6, 8, 6);
//        edges[13] = new Edge(7, 8, 7);

        for (int i = 0; i < N; i++) {
            graph.insertEdge(edges[i]);
        }

        graph.bianli();
        graph.Prim();
    }

    class Edge {

        private int v1;
        private int v2;
        private int weight;

        /**
         * 为查找最小边专门所设
         *
         * @param weight
         */
        public Edge(int weight) {
            this.v1 = -1;
            this.v2 = -1;
            this.weight = weight;
        }

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            String str = "[ " + v1 + " , " + v2 + " , " + weight + " ]";
            return str;
        }

        public boolean equals(Edge edge) {
            boolean equal = this.v1 == edge.getV1() && this.v2 == edge.getV2() && this.weight == edge.getWeight()
                    || this.v1 == edge.getV2() && this.v2 == edge.getV1() && this.weight == edge.getWeight();
            return equal;
        }
    }

    class Graph {

        private int vNum;
        private int edgeNum;
        private LinkedList<Edge>[] edgeLinks;
        private LinkedList<Integer> TV;    //已在树中的顶点集
        private LinkedList<Edge> T;    //入选的边集

        public Graph(int vNum) {
            this.vNum = vNum;
            this.edgeNum = 0;
            edgeLinks = new LinkedList[vNum];
            for (int i = 0; i < vNum; i++) {
                edgeLinks[i] = new LinkedList<>();
            }
        }

        public void insertEdge(Edge edge) {
            int v1 = edge.getV1();
            int v2 = edge.getV2();
            edgeLinks[v1].add(edge);
            Edge edge2 = new Edge(v2, v1, edge.getWeight());
            edgeLinks[v2].add(edge2);
            edgeNum++;
        }

        public void deleteEdge(Edge edge) {
            int v1 = edge.getV1();
            int v2 = edge.getV2();
            Edge edge2 = new Edge(v2, v1, edge.getWeight());
            edgeLinks[v1].remove(edge);
            edgeLinks[v2].remove(edge2);
            edgeNum--;
        }

        public void bianli() {
            //System.out.println("共有 " + vNum + " 个顶点， " + edgeNum + " 条边。");
            for (int i = 0; i < vNum; i++) {
                LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[i].clone();
                //System.out.print(i + " : [");
                while (!list.isEmpty()) {
                    Edge edge = list.pop();
                    //System.out.print(edge.getV2() + "(" + edge.getWeight() + ")" + "  ");
                }
                //System.out.println("]");
            }
        }

        /**
         * Prim算法实现
         */
        public void Prim() {

            TV = new LinkedList<>();
            T = new LinkedList<>();
            TV.add(0);

            while (edgeNum > 0 && T.size() != vNum - 1) {
                Edge edge = getMinEdge(TV);
                if (edge == null)
                    break;
                this.deleteEdge(edge);
                T.add(edge);
                TV.add(edge.getV2());
            }

            if (T.size() == vNum - 1) {
                //System.out.println("求最小生成树成功");
                LinkedList<Edge> list = (LinkedList<Edge>) T.clone();
                int sumWeight = 0;
                while (!list.isEmpty()) {
                    Edge edge = list.pop();
                    sumWeight += edge.getWeight();
                    System.out.println(edge.toString());
                }
                System.out.println("总的权重为： " + sumWeight);
            } else {
                //System.out.println("无最小生成树");
            }


        }

        public Edge getMinEdge(LinkedList<Integer> t) {

            Edge minEdge = new Edge(10000);
            LinkedList<Integer> tt = (LinkedList<Integer>) t.clone();

            while (!tt.isEmpty()) {
                int i = tt.pop();
                LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[i].clone();
                while (!list.isEmpty()) {
                    Edge edge = list.pop();
                    if (minEdge.getWeight() > edge.getWeight() && !t.contains(edge.getV2())) {
                        minEdge = edge;
                    }
                }
            }

            if (minEdge.getWeight() == 10000)
                return null;
            return minEdge;
        }

    }

}

class Main {
    // AC
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//            while(scanner.hasNext()){
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int len = arr.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();

        int count = 0;
        for (int i = 0; i < k; i++) {
            int temp = hashMap.getOrDefault(arr[i], 0);
            hashMap.put(arr[i], ++temp);
            if (temp == t) {
                hashSet.add(arr[i]);
            }
        }

        if (!hashSet.isEmpty()) {
            count++;
        }

        for (int i = 1, j = k; i <= len - k; i++, j++) {
            int temp = hashMap.get(arr[i-1]);
            temp--;
            hashMap.put(arr[i-1], temp);
            if (temp < t) {
                hashSet.remove(arr[i-1]);
            }


            temp = hashMap.getOrDefault(arr[j],0);
            temp++;
            hashMap.put(arr[j], temp);
            if (temp >= t) {
                hashSet.add(arr[j]);
            }
            if (!hashSet.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }


}
