package com.wenjiehe.Algorithm;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by wenjie on 17/02/26.
 */
public class GraphyLinkedList {
    class Vertex {
        private Object value;//一个名字，标签，没什么用
        private int vvalue;//顶点的值
        LinkedList<Node> elist = new LinkedList<>();

        Vertex(Object value, int vvalue) {
            this.value = value;
            this.vvalue = vvalue;
        }
    }

    class Node {
        private int nvalue;
        private int weight;

        Node(int nvalue, int weight) {
            this.nvalue = nvalue;//边结点的值
            this.weight = weight;
        }

        int getNvalue() {
            return nvalue;
        }

        int getWeight() {
            return weight;
        }
    }

    //Vertexs
    private List<Vertex> vertexs;
    private int numOfEdges;//边的条数

    public GraphyLinkedList(int n) {
        vertexs = new ArrayList<>(n);
        numOfEdges = 0;
    }

    public List<Vertex> getVertexs() {
        return vertexs;
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public int getNumOfVertexs() {
        return vertexs.size();
    }

    public Vertex getVertex(int vvalue) {
        return vertexs.get(vvalue);
    }

    public Object getValue(int i) {
        Vertex v = getVertex(i);
        if (v != null)
            return v.value;
        else
            return null;
    }

    public int getWeight(int v1, int v2) {
        Vertex vertex1 = getVertex(v1);
        //Vertex vertex2 = getVertex(v2);
        Iterator it = vertex1.elist.iterator();
        while (it.hasNext()) {
            Node node = (Node) it.next();
            if (node.getNvalue() == v2) {
                return node.getWeight();
            }
        }
        return -1;
    }

    public void insertVertex(Object value, int vvalue) {
        vertexs.add(new Vertex(value, vvalue));
    }

    public void insertEdge(int v1, int v2, int weight) {
        Vertex vertex1 = getVertex(v1);
        Node node = new Node(v2, weight);
        vertex1.elist.add(node);
        numOfEdges++;
    }

    public void deleteVertex(int vvalue) {
        vertexs.remove(vvalue);
    }

    public void deleteEdge(int v1, int v2) {
        Vertex vertex1 = getVertex(v1);
        Iterator it = vertex1.elist.iterator();
        while (it.hasNext()) {
            Node node = (Node) it.next();
            if (node.getNvalue() == v2) {
                vertex1.elist.remove(node);
                numOfEdges--;
            }
        }
    }

    public int getFirstNeighbour(int i) {
        Vertex v = getVertex(i);
        if (v == null)
            return -1;
        if (v.elist.size() == 0)
            return -1;
        Node node = v.elist.get(0);
        if (node != null)
            return node.nvalue;
        return -1;
    }

    public int getNextNeighbour(int v1, int v2) {
        Vertex vertex1 = getVertex(v1);
        Iterator<Node> it = vertex1.elist.iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.nvalue == v2) {
                if (it.hasNext()) {
                    return ((Node) it.next()).nvalue;
                } else {
                    System.out.println("no next node");
                }
            }
        }
        return -1;
    }


    /**
     * 所谓深度优先遍历,就是首先访问第一个邻接结点，然后再以这个被访问的邻接结点作为初始结点，访问它的第一个邻接结点（未被访问过的）。
     * 总结起来可以这样说：每次都在访问完当前结点后首先访问当前结点的第一个邻接结点。
     *
     * @param a       邻接表
     * @param visited 已访问过的顶点集合
     * @param k       当前访问的定点的下标
     */
    public static void deepTravel(GraphyLinkedList a, boolean[] visited, int k) {
        List<Vertex> list = a.getVertexs();
        visited[k] = true;
        System.out.println(a.getValue(k));
        Vertex v = list.get(k);
        for (int i = 0; i < v.elist.size(); i++) {
            if (!visited[v.elist.get(i).nvalue])
                deepTravel(a, visited, v.elist.get(i).nvalue);
        }

    }

    /**
     * 沿树的宽度遍历树的节点 BFS breadth-first search
     * <p>
     * 步骤：
     * 先把这一层的顶点的下边加入到visited集合中，再根据这一层的vertex，找到其邻接表中尚未被访问过的vertex的下标，
     * 加入到nextLayer中；再次遍历这一层顶点。
     *
     * @param a       邻接表
     * @param visited 已访问过的顶点集合
     * @param layer   这一层的顶点的下标
     */
    public static void widthTravel(GraphyLinkedList a, Set visited, List layer) {
        List<Vertex> list = a.getVertexs();
        for (int i = 0; i < layer.size(); i++) {
            System.out.println(a.getValue((Integer) layer.get(i)));
            visited.add(layer.get(i));
        }

        //layer.removeAll(visited);

        List nextLayer = new ArrayList();
        for (int i = 0; i < layer.size(); i++) {
            int index = (int) layer.get(i);
            Vertex v = list.get(index);
            Iterator it = v.elist.iterator();
            while (it.hasNext()) {
                Node node = (Node) it.next();
                if (nextLayer.indexOf(node.getNvalue()) < 0)
                    nextLayer.add(node.getNvalue());
            }
        }

        nextLayer.removeAll(visited);
        if (!nextLayer.isEmpty())
            widthTravel(a, visited, nextLayer);
    }

    public static void topSort(GraphyLinkedList a) {
        int numVertex = a.getNumOfVertexs();
        int[] dege = new int[numVertex];
        int[] tops = new int[numVertex];
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < numVertex; i++) {
            Vertex v = a.getVertex(i);
            for (int j = 0; j < v.elist.size(); j++) {
                dege[v.elist.get(j).nvalue]++;
            }
        }

        for (int i = 0; i < numVertex; i++) {
            if (dege[i] == 0) {
                q.offer(i);
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            int i = q.poll().intValue();
            Vertex v = a.getVertex(i);
            tops[index++] = Integer.valueOf((String) v.value);
            Iterator<Node> it = v.elist.iterator();
            while (it.hasNext()) {
                Node node = it.next();
                dege[node.getNvalue()]--;
                if (dege[node.getNvalue()] == 0) {
                    q.offer(node.getNvalue());
                }
            }
        }

        if (index != numVertex) {
            System.out.println("有个环");
            return;
        }
        //输出排序结果
        System.out.print("拓扑排序: ");
        for (int i = 0; i < numVertex; i++) {
            System.out.print(tops[i] + " ");
        }
    }


    public static void dijstra(GraphyLinkedList a, int k) {
        Map<Integer, Integer> map = new HashMap();
        int min = Integer.MAX_VALUE;
        int[] cost = new int[a.getNumOfVertexs()];
        boolean[] visited = new boolean[a.getNumOfVertexs()];

        for (int i = 1; i < cost.length; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        int num = 0;
        visited[k] = true;
        Vertex vk = a.getVertex(k);
        Iterator<Node> itK = vk.elist.iterator();
        while (itK.hasNext()) {
            Node node = itK.next();
            cost[node.getNvalue()] = node.getWeight();
        }

        while (num < a.getNumOfVertexs()) {

            min = findCostMinimum(visited, cost);
            num++;
            visited[min] = true;

            Vertex smallestVertex = a.getVertex(min);
            Iterator<Node> itSmallestVertex = smallestVertex.elist.iterator();
            while (itSmallestVertex.hasNext()) {
                Node node = itSmallestVertex.next();
                if (!visited[node.getNvalue()]) {
                    int nodeCost = node.getWeight();
                    if (cost[node.getNvalue()] > cost[min] + nodeCost) {
                        map.put(node.getNvalue(), min);
                        cost[node.getNvalue()] = cost[min] + nodeCost;
                    }
                }
            }
        }

        for (int i = 0; i < cost.length; i++) {
            System.out.println(cost[i]);

        }
        System.out.println(map);
    }

    public static int findCostMinimum(boolean[] visited, int[] cost) {
        int min = Integer.MAX_VALUE;
        int retur = 0;
        for (int i = 0; i < cost.length; i++) {
            if (min > cost[i] && !visited[i]) {
                retur = i;
                min = cost[i];
            }
        }

        return retur;
    }

    public static void prim(GraphyLinkedList a, int start) {
        Map<Integer, Integer> noVisited = new HashMap<>();
        Map<Integer, Integer> hasVisited = new HashMap<>();
        int cost = 0;
        for (int i = 1; i < a.getNumOfVertexs(); i++) {
            //Vertex v = a.getVertex(i);
            noVisited.put(i, -1);
        }
        hasVisited.put(0, 0);
        int num = 1;
        while (num < a.getNumOfVertexs()) {
            int[] result = findMinVertex(a, noVisited, hasVisited);
            int index = result[0];
            int weight = result[1];
            int from = result[2];
            //System.out.println("Prim"+index+"-"+weight);
            cost += weight;
            noVisited.remove(index);
            hasVisited.put(index, from);
            num++;
        }


        System.out.println("Prim minimum:" + cost);

        for (int i = 0; i < hasVisited.size(); i++) {
            System.out.println(i+"-"+hasVisited.get(i));
        }

    }

    public static int[] findMinVertex(GraphyLinkedList a, Map<Integer, Integer> noVisited, Map<Integer, Integer> hasVisited) {
        int min = Integer.MAX_VALUE;
        int weight = Integer.MAX_VALUE;
        int from = -1;

        Set s = hasVisited.keySet();
        Iterator<Integer> iterator = s.iterator();
        while (iterator.hasNext()) {
            Vertex v = a.getVertex(iterator.next());
            //System.out.println(v.value);
            Iterator<Node> it = v.elist.iterator();
            while (it.hasNext()) {
                Node node = it.next();
                if (noVisited.get(node.getNvalue()) != null && node.getWeight() < weight) {

                    min = node.getNvalue();
                    weight = node.getWeight();
                    from = v.vvalue;
                }
            }

        }
        //System.out.println("---------");
        return new int[]{min, weight, from};
    }

    public static void main(String[] args) {
        /*int i=0;
        int n=4,e=4;//分别代表结点个数和边的数目
        String labels[]={"V1","V2","V3","V4"};//结点的标识
        GraphyLinkedList graph=new GraphyLinkedList(n);
        for(String label:labels) {
            graph.insertVertex(label, i);//插入结点
            i++;
        }
        //插入四条边
        graph.insertEdge(0, 1, 2);
        graph.insertEdge(0, 2, 5);
        graph.insertEdge(2, 3, 8);
        graph.insertEdge(3, 0, 7);

        System.out.println("结点个数是："+graph.getNumOfVertexs());
        System.out.println("边的个数是："+graph.getNumOfEdges());

//            graph.deleteEdge(0, 1);//删除<V1,V2>边
//            System.out.println("删除<V1,V2>边后...");
//            System.out.println("结点个数是："+graph.getNumOfVertex());
//            System.out.println("边的个数是："+graph.getNumOfEdges());
        System.out.println(graph.getFirstNeighbour(0));
        System.out.println(graph.getNextNeighbour(0, 1));
        System.out.println("---------------------");
        List<Vertex> vlist = graph.vertexs;
        for(Vertex v:vlist){
            System.out.println(v.value+" "+v.vvalue+":");
            LinkedList<Node> elist = v.elist;
            for (Node node : elist) {
                System.out.println("  "+node.nvalue+"--"+node.weight);
            }
        }*/

        /*String labels[]={"1","2","3","4","5","6","7","8"};//结点的标识
        GraphyLinkedList a=new GraphyLinkedList(8);
        int i=0;
        for(String label:labels) {
            a.insertVertex(label, i);//插入结点
            i++;
        }
        a.insertEdge(0, 1, 1);
        a.insertEdge(0, 2, 1);
        a.insertEdge(1, 3, 1);
        a.insertEdge(1, 4, 1);
        a.insertEdge(3, 7, 1);
        a.insertEdge(4, 7, 1);
        a.insertEdge(2, 5, 1);
        a.insertEdge(2, 6, 1);
        a.insertEdge(5, 6, 1);
        a.insertEdge(1, 0, 1);
        a.insertEdge(2, 0, 1);
        a.insertEdge(3, 1, 1);
        a.insertEdge(4, 1, 1);
        a.insertEdge(7, 3, 1);
        a.insertEdge(7, 4, 1);
        a.insertEdge(4, 2, 1);
        a.insertEdge(5, 2, 1);
        a.insertEdge(6, 5, 1);

        boolean [] visited=new boolean[a.getNumOfVertexs()];
        long timebefore = new Date().getTime();
        deepTravel(a, visited, 0);
        long timeafter = new Date().getTime();
        //System.out.println(timeafter-timebefore);

        long timebefore2 = new Date().getTime();
        //deepTravelL(a, visited, 0);
        long timeafter2 = new Date().getTime();
        //System.out.println(timeafter2-timebefore2);

*/

    /*    String labels[]={"1","2","3","4","5","6","7","8"};//结点的标识
        GraphyLinkedList a=new GraphyLinkedList(8);
        int i=0;
        for(String label:labels) {
            a.insertVertex(label, i);//插入结点
            i++;
        }
        a.insertEdge(0, 1, 1);
        a.insertEdge(0, 2, 1);
        a.insertEdge(1, 3, 1);
        a.insertEdge(1, 4, 1);
        a.insertEdge(3, 7, 1);
        a.insertEdge(4, 7, 1);
        a.insertEdge(2, 5, 1);
        a.insertEdge(2, 6, 1);
        a.insertEdge(5, 6, 1);
        a.insertEdge(1, 0, 1);
        a.insertEdge(2, 0, 1);
        a.insertEdge(3, 1, 1);
        a.insertEdge(4, 1, 1);
        a.insertEdge(7, 3, 1);
        a.insertEdge(7, 4, 1);
        a.insertEdge(4, 2, 1);
        a.insertEdge(5, 2, 1);
        a.insertEdge(6, 5, 1);

        Set visited=new HashSet();
        List layer=new ArrayList();
        layer.add(0);
        widthTravel(a, visited, layer);*/

        /*String labels[]={"1","2","3","4","5","6","7"};//结点的标识
        GraphyLinkedList a=new GraphyLinkedList(8);
        int i=0;
        for(String label:labels) {
            a.insertVertex(label, i);//插入结点
            i++;
        }
        a.insertEdge(0, 1, 1);
        a.insertEdge(0, 3, 1);
        a.insertEdge(0, 5, 1);
        a.insertEdge(1, 6, 1);
        a.insertEdge(3, 2, 1);
        a.insertEdge(4, 6, 1);
        a.insertEdge(5, 6, 1);
        a.insertEdge(6, 2, 1);

        topSort(a);*/

        /*String labels[]={"0","1","2","3","4"};//结点的标识
        GraphyLinkedList a=new GraphyLinkedList(5);
        int i=0;
        for(String label:labels) {
            a.insertVertex(label, i);//插入结点
            i++;
        }
        a.insertEdge(0, 1, 10);
        a.insertEdge(0, 3, 30);
        a.insertEdge(0, 4, 100);
        a.insertEdge(1, 2, 50);
        a.insertEdge(2, 4, 10);
        a.insertEdge(3, 2, 20);
        a.insertEdge(3, 4, 60);

        dijstras(a, 0);*/

        String labels[] = {"A", "B", "C", "D", "E", "F", "G"};//结点的标识
        GraphyLinkedList g = new GraphyLinkedList(7);
        int i = 0;
        for (String label : labels) {
            g.insertVertex(label, i);//插入结点
            i++;
        }

        g.insertEdge(0, 1, 12);
        g.insertEdge(0, 5, 16);
        g.insertEdge(0, 6, 14);
        g.insertEdge(1, 0, 12);
        g.insertEdge(1, 2, 10);
        g.insertEdge(1, 5, 7);
        g.insertEdge(2, 1, 10);
        g.insertEdge(2, 3, 3);
        g.insertEdge(2, 4, 5);
        g.insertEdge(2, 5, 6);
        g.insertEdge(3, 2, 3);
        g.insertEdge(3, 4, 4);
        g.insertEdge(4, 2, 5);
        g.insertEdge(4, 3, 4);
        g.insertEdge(4, 5, 2);
        g.insertEdge(4, 6, 8);
        g.insertEdge(5, 0, 16);
        g.insertEdge(5, 1, 7);
        g.insertEdge(5, 2, 6);
        g.insertEdge(5, 4, 2);
        g.insertEdge(5, 6, 9);
        g.insertEdge(6, 0, 14);
        g.insertEdge(6, 4, 8);
        g.insertEdge(6, 5, 9);

        prim(g, 0);
    }

    public static void deepTravelL(GraphyLinkedList a, boolean[] visited, int k) {
        List<Vertex> vertexs = a.getVertexs();

        visited[k] = true;

        System.out.println(a.getValue(k));
        LinkedList<Node> elist = vertexs.get(k).elist;
        Iterator<Node> iterator = elist.iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (visited[node.getNvalue()] == false) deepTravelL(a, visited, node.getNvalue());
        }
    }

    public static void dijstras(GraphyLinkedList a, int k) {
        Map map = new HashMap();//存储节点号--最小路径值
        List<Vertex> vertexs = a.getVertexs();
        while (true) {
            int min = Integer.MAX_VALUE;
            int min_no = -1;
            Vertex first = vertexs.get(k);//获得初始节点

            Iterator<Node> iterator = first.elist.iterator();
            while (iterator.hasNext()) {
                Node node = iterator.next();
                //选出路径最短的节点
                if (map.get(node.getNvalue()) == null && node.getWeight() < min) {
                    min_no = node.getNvalue();
                    min = node.getWeight();
                }
            }

            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                //取出集合中存在的最短路径节点
                int index = (Integer) it.next();
                int weight = (Integer) map.get(index);

                Iterator<Node> iterator2 = vertexs.get(index).elist.iterator();
                while (iterator2.hasNext()) {
                    Node node2 = iterator2.next();
                    //将集合中的节点自身的权值加上下 一个节点的权值与外面非集合中的权值比较 取最小值 循环
                    if (map.get(node2.getNvalue()) == null && node2.getWeight() + weight < min) {
                        min_no = node2.getNvalue();
                        min = node2.getWeight() + weight;
                    }
                }
            }
            //出口
            if (min < Integer.MAX_VALUE)
                map.put(min_no, min);
            else
                break;
        }

        System.out.println(map);
    }

}
