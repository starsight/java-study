package com.wenjiehe.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class P637 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> q = new ArrayDeque<>();
            List<Double> result = new ArrayList<>();

            if(root!=null)
                q.add(root);

            int oldCount =1;
            int newCount =0;
            double sum =0;
            int count =1;

            while(!q.isEmpty()){
                TreeNode treeTemp =q.poll();
                oldCount--;
                sum+=treeTemp.val;
                if(treeTemp.left!=null){
                    q.add(treeTemp.left);
                    newCount++;
                }
                if(treeTemp.right!=null){
                    q.add(treeTemp.right);
                    newCount++;
                }

                if(oldCount==0){
                    oldCount =newCount;
                    newCount =0;
                    result.add(1.0*sum/count);
                    count = oldCount;
                    sum=0;
                }

            }

            return result;


        }
    }
}
