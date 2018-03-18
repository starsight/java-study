package com.wenjiehe.ReAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class choiceRedDot {
    /***
r->a,r->b,r->c,a->e,b->g,c->g,c->h,g->f
e:15,f:10,h:6
     */

    static class Node{
        String label;
        int val=0;
        ArrayList<Node> next;
        Node(){
            next = new ArrayList<>();
        }
    }

    static String choiceRedDot(String nodePath, String nodeCount) {
        String[] link = nodePath.split(",");
        String[] count = nodeCount.split(",");

        String[] temp;
        //Node root =new Node();
        Node node1 =null;
        Node node2 =null;
        HashMap<String,Node> hashMap = new HashMap<>();
        ArrayList<Node> list =new ArrayList<>();
        for (String aLink : link) {
            temp = aLink.split("->");
            if (hashMap.containsKey(temp[0])) {
                node1 = hashMap.get(temp[0]);
            } else {
                node1 = new Node();
                node1.label =temp[0];
                hashMap.put(temp[0], node1);
            }

            if (hashMap.containsKey(temp[1])) {
                node2 = hashMap.get(temp[1]);
            } else {
                node2 = new Node();
                node2.label =temp[1];
                hashMap.put(temp[1], node2);
            }

            node1.next.add(node2);

            if (temp[0].equals("r")) {
                list.add(node2);
            }
        }

        for(String cCount :count){
            temp = cCount.split(":");
            node1 = hashMap.get(temp[0]);
            node1.val = Integer.valueOf(temp[1]);
        }

        int max =-1;

        for(Node node:list){
            int sum =calculate(node);
            if(max<sum){
                max = sum;
                node1 =node;
            }
        }
        return node1.label;

    }

    public static int calculate(Node node){
        ArrayList<Node> list = node.next;

        if(node.val!=0)
            return node.val;

        int sum =node.val;
        for (Node n: list) {
            sum+=calculate(n);
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _nodePath;
        try {
            _nodePath = in.nextLine();

        } catch (Exception e) {
            _nodePath = null;
        }

        String _nodeCount;
        try {
            _nodeCount = in.nextLine();
        } catch (Exception e) {
            _nodeCount = null;
        }

        res = choiceRedDot(_nodePath, _nodeCount);
        System.out.println(res);
    }
}
