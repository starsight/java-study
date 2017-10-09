package com.wenjiehe.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/9/19.
 */
public class P106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==1)
            return new TreeNode(postorder[0]);
        else if(postorder.length==0)
            return null;

        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index = findRootInOrder(root.val,inorder);

        int[] leftinorder = Arrays.copyOfRange(inorder,0,index);
        int[] rightinorder = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] leftpostorder = Arrays.copyOfRange(postorder,0,leftinorder.length);
        int[] rightpostorder = Arrays.copyOfRange(postorder,leftinorder.length,postorder.length-1);

        root.left = buildTree(leftinorder,leftpostorder);
        root.right = buildTree(rightinorder,rightpostorder);

        return root;

    }

    public int findRootInOrder(int root,int[] inorder){
        for (int i = 0; i < inorder.length; i++) {
            if (root == inorder[i]){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        P106 p =new P106();
        p.buildTree(new int[]{8 ,4 ,10 ,9 ,11 ,2 ,5 ,1 ,6 ,3, 7}, new int[]{8 ,10 ,11 ,9 ,4 ,5 ,2 ,6 ,7 ,3 ,1});
        ;
    }
}
