package com.wenjiehe.leetcode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class P109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;

        List<TreeNode> treeNodeList = new ArrayList<>();
        while(head!=null){
            treeNodeList.add(new TreeNode(head.val));
            head = head.next;
        }
        return sortListToBSTHelper(treeNodeList,0,treeNodeList.size()-1);
    }

    public TreeNode sortListToBSTHelper(List<TreeNode> list, int from,int end){
        if(end==from)
            return list.get(end);
        
            
        int middle = from+ ((end-from)>>1);
        
        TreeNode leftTree = sortListToBSTHelper(list, from, middle);
        TreeNode rightTree = sortListToBSTHelper(list, middle+1, end);

        list.get(middle).left =  (list.get(middle)==leftTree)?null:leftTree;
        list.get(middle).right =  (list.get(middle)==rightTree)?null:rightTree; 

        return list.get(middle);
    }
}