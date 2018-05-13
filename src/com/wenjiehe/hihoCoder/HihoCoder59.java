package com.wenjiehe.hihoCoder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author wenjie
 */
public class HihoCoder59 {

    public static void main(String[] args) {
        solution02();
        /*Scanner in = new Scanner(System.in);
        int num = Integer.valueOf(in.nextLine());

        while(num>0){
            num--;
            String a =in.nextLine();
            String b =in.nextLine();
            solution01(a,b);
        }*/
    }

    public static void solution01(String a,String b){
        if(a.length()!=b.length()){
            System.out.println("NO");
            return ;
        }

        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();

        int[] result =new int[26];
        for (int i = 0; i < result.length; i++) {
            result[i]=Integer.MIN_VALUE;
        }
        for (int i = 0; i < charA.length; i++) {
            if (result[charA[i]-'a']==Integer.MIN_VALUE){
                result[charA[i]-'a'] = charA[i]-charB[i];
            }else{
                if(result[charA[i]-'a']!=charA[i]-charB[i]){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }



    public static void solution02(){
        Scanner in = new Scanner(System.in);
        int num = Integer.valueOf(in.nextLine());

        HashMap<Integer,Node> hashMap = new HashMap<>();
        Node node;
        for (int i = 1; i < num; i++){
            String temp = in.nextLine();
            String[] arrTemp = temp.split(" ");

            int i0 =Integer.valueOf(arrTemp[0]);
            int i1 =Integer.valueOf(arrTemp[1]);
            if(hashMap.containsKey(i0)){
                node = hashMap.get(i0);
                Node node1;
                if(hashMap.containsKey(i1)){
                    node1 =hashMap.get(i1);
                }else{
                    node1 =new Node(i1,1);
                    hashMap.put(i1,node1);
                }

                node.list.add(node1);
                node1.list.add(node);

            }else{
                node =new Node(i0,1);
                Node node1;
                if(hashMap.containsKey(i1)){
                    node1 =hashMap.get(i1);
                }else{
                    node1 =new Node(i1,1);
                    hashMap.put(i1,node1);
                }

                node.list.add(node1);
                node1.list.add(node);
                hashMap.put(i0,node);
            }

        }


        HashMap<String,Integer> hashMap1 = new HashMap<>();

        for (int i = 0; i < num; i++) {

            boolean[] result = new boolean[num];
            node  = hashMap.get(i+1);

            node.weight=0;
            int sum =0;
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            result[node.nvalue-1] =true;

            while(!stack.isEmpty()){
                Node node1 = stack.pop();

                for (int j = 0; j < node1.list.size(); j++) {
                    Node node2 = node1.list.get(j);
                    if(!result[node2.nvalue-1]){
                        node2.weight= node1.weight+1;
                        sum+=node2.weight;
                        result[node2.nvalue-1] =true;
                        stack.push(node2);
                    }
                }

            }
            System.out.println(sum);

        }


    }

}

class Node {
    int nvalue;
    int weight;
    LinkedList<Node> list = new LinkedList<>();

    Node(int nvalue, int weight) {
        //边结点的值
        this.nvalue = nvalue;
        this.weight = weight;
    }
}
