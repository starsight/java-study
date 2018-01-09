package com.wenjiehe.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null)
            return (l1==null)?l2:l1;
        
        ListNode newHead = (l1.val<=l2.val)?l1:l2;
        ListNode anotherCur = (newHead==l1)?l2:l1;

        ListNode newHeadCur =newHead.next;
        ListNode newHeadPre = newHead;

        while(newHeadCur!=null&&anotherCur!=null){
            if(newHeadCur.val<=anotherCur.val){
                newHeadPre.next = newHeadCur;
                newHeadPre = newHeadCur;
                newHeadCur =newHeadCur.next;
                //anotherCur =anotherCur.next;
            }else{
                //newHeadCur = newHeadCur.next;

                newHeadPre.next = anotherCur;
                newHeadPre = newHeadPre.next;
                //newHeadPre.next =null;

                anotherCur =anotherCur.next;
            }
        }

        if(newHeadCur==null)
            newHeadPre.next =anotherCur;
        else
            newHeadPre.next = newHeadCur;

        return newHead;
    }
}