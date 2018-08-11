package com.wenjiehe.QiuZhao;

import java.util.Arrays;
import java.util.Scanner;

import sun.reflect.generics.tree.Tree;

public class PinDuoDuo02 {
//    // i:表示要插入后序序列的位置对于生成的后序序列，应该从最后位置开始写，
//    //从索引最大值递减依此先写入根，然后写入右子树，最后写左子树
//    public static int i = 0;
//    public static void getLast(int[] pre, int[] mid, int[] last)
//    {
//        // 如果序列的长度小于等于1，将该序列中的元素插入last序列，然后返回
//        if (pre.length <= 1) {
//            last[i] = pre[0];
//            i--;
//            return;
//        }
//        //如果序列长度大于1，则将二叉树的根插入last序列，然后将序列分成两个，分别进行递归
//        else {
//            //添加元素
//            last[i] = pre[0];
//            i--;
//            int j = 0;
//            // 在mid中找到根元素，从此处将mid分成两部分
//            for (; j < mid.length && pre[0] != mid[j]; j++);
//            //循环结束后j为根元素在mid中的索引位置
//            //两部分以mid分开
//            int[] newmid1 = new int[j];//j-1
//            int[] newmid2 = new int[mid.length - j - 1];
//            int[] newpre1 = new int[j];
//            int[] newpre2 = new int[mid.length - j - 1];
//            // 求右子树的后序序列
//            //必须要保证j < mid.length - 1，当相等的时候，表示没有右子树
//            if (j < mid.length - 1)
//            {
//                //初始化右子树
//                for (int n = 0; n < mid.length - j - 1; n++) {
//                    newmid2[n] = mid[n + j + 1];
//                    newpre2[n] = pre[n + j + 1];
//                }
//                getLast(newpre2, newmid2, last);
//            }
//            // 求左子树的后序序列
//            //必须要保证j>0，当相等的时候，表示没有左子树
//            if (j > 0) {
//                for (int m = 0; m < j; m++) {
//                    newmid1[m] = mid[m];
//                    newpre1[m] = pre[m + 1];
//                }
//                getLast(newpre1, newmid1, last);
//            }
//        }
//    }
//    public static void main(String[] args) {
//
//
//
//        Scanner in = new Scanner(System.in);
//        int n = Integer.valueOf(in.nextLine());
//        int[] pre = new int[n];
//        int[] mid = new int[n];
//        int[] last = new int[n];
//
//        String s1 = in.nextLine();
//        String s2 = in.nextLine();
//        String[] s11 = s1.split(" ");
//        String[] s21 = s2.split(" ");
//
//        if(s11.length!=s21.length||s11.length!=n)
//            return ;
//
//
//        for(int i=0;i<n;i++){
//            pre[i]= Integer.valueOf(s11[i]);
//        }
//        for(int i=0;i<n;i++){
//            mid[i] = Integer.valueOf(s21[i]);
//        }
//
//
//        i = mid.length-1;
//        getLast(pre, mid,last);
//        for(int j=0;j<last.length-1;j++){
//            System.out.print(last[j]+" ");
//        }
//        System.out.print(last[n-1]);
//
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String[] pre = new String[n];
        String[] mid = new String[n];

        //String s1 = in.nextLine();
        //String s2 = in.nextLine();
        //String[] s11 = s1.split(" ");
        //String[] s21 = s2.split(" ");

        //if(s11.length!=s21.length||s11.length!=n)
        //    return ;


        for(int i=0;i<n;i++){
            pre[i]= in.next();
        }
        for(int i=0;i<n;i++){
            mid[i] = in.next();
        }

        reConstructBinaryTree(pre,mid);
        sys(root);
    }

     static void sys(TreeNode root1){
        if(root1.left!=null){
            sys(root1.left);
        }
        if(root1.right!=null){
            sys(root1.right);
        }
        if(root1!=root)
         System.out.print(root1.val+" ");
        else
            System.out.println(root.val);
     }

     static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String x) {
            val = x;
        }
    }
    /**
     * 前序遍历:1 2 4 8 9 10 11 5 3 6 7
     * 中序遍历:8 4 10 9 11 2 5 1 6 3 7
     * */
    static TreeNode root = null;
    public static TreeNode reConstructBinaryTree(String [] pre,String [] in) {
        if(pre.length==1){
            return new TreeNode(pre[0]+"");
        }else if(pre.length==0){
            return null;
        }

        TreeNode t0 = new TreeNode(pre[0]+"");
        if(root == null){
            root = t0;
        }

        int weizi = findT0In(pre[0],in);
        String[] zuopre = Arrays.copyOfRange(pre,1,weizi+1);
        String[] zuoin = Arrays.copyOfRange(in,0,weizi);
        String[] youpre = Arrays.copyOfRange(pre,weizi+1,pre.length);
        String[] youin = Arrays.copyOfRange(in,weizi+1,in.length);

        t0.left = reConstructBinaryTree(zuopre,zuoin);
        t0.right = reConstructBinaryTree(youpre,youin);
        return t0;
    }

    public static int findT0In(String p0,String[] in) {
        for (int i = 0; i < in.length; i++) {
            if (p0.equals(in[i])){
                //System.out.println(i);
                return i;
            }

        }
        return 0;
    }
}
