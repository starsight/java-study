package com.wenjiehe.JavaSE;

import java.util.Arrays;

/**
 * Created by yiyuan on 16/11/9.
 */
public class RebuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }



  }
  /**
   * 前序遍历:1 2 4 8 9 10 11 5 3 6 7
   * 中序遍历:8 4 10 9 11 2 5 1 6 3 7
   * */
    TreeNode root = null;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==1){
            return new TreeNode(pre[0]);
        }else if(pre.length==0){
            return null;
        }

        TreeNode t0 = new TreeNode(pre[0]);
        if(root == null){
            root = t0;
        }

        int weizi = findT0In(pre[0],in);
        int[] zuopre = Arrays.copyOfRange(pre,1,weizi+1);
        System.out.println(Arrays.toString(zuopre));
        int[] zuoin = Arrays.copyOfRange(in,0,weizi);
        System.out.println(Arrays.toString(zuoin));
        int[] youpre = Arrays.copyOfRange(pre,weizi+1,pre.length);
        System.out.println(Arrays.toString(youpre));
        int[] youin = Arrays.copyOfRange(in,weizi+1,in.length);
        System.out.println(Arrays.toString(youin));

        t0.left = reConstructBinaryTree(zuopre,zuoin);
        t0.right = reConstructBinaryTree(youpre,youin);
        return t0;
    }

    public int findT0In(int p0,int[] in) {
        for (int i = 0; i < in.length; i++) {
            if (p0 == in[i]){
                System.out.println(i);
                return i;
            }

        }
        return 0;
    }
}
