package com.wenjiehe.leetcode;


/**
 * Created by Administrator on 2018/1/9.
 */
public class P147 {
    public static ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;

        ListNode newHead =null;
        ListNode newHeadCur =newHead;
        ListNode newHeadNext =newHead;


        while(head!=null){
            newHeadNext = getSmallestAndRemoveNode(head);

            if(head==newHeadNext){
                head = head.next;
            }

            if(newHead==null){
                newHead = newHeadNext;
                newHeadCur = newHead;
                newHeadCur.next=null;
            }else{
                newHeadCur.next = newHeadNext;
                newHeadCur = newHeadCur.next;
                newHeadCur.next = null;
            }


        }

        return newHead;
    }

    public static ListNode getSmallestAndRemoveNode(ListNode oldHead){
        ListNode head = oldHead;
        ListNode pre = null;
        ListNode preCur = head;
        ListNode cur = head.next;
        int min = head.val;
        while(cur!=null){
            if(cur.val<min){
                min = cur.val;
                pre = preCur;
                preCur = cur;
                cur = cur.next;
            }else{
                preCur = cur;
                cur = cur.next;
            }
        }

        if(pre==null){
            return oldHead;
        }else{
            cur = pre.next;
            pre.next = pre.next.next;
            cur.next=null;
            return cur;
        }
    }

    public static void main(String[] args) {
        ListNode head =new ListNode(1);
        ListNode cur = head;
        //cur = cur.next;
//        for (int i = 1; i < 7; i++) {
//            ListNode temp  =new ListNode(10-i);
//            cur.next =temp;
//            cur = cur.next;
//        }
        ListNode temp  =new ListNode(1);
        cur.next =temp;

        insertionSortList(head);
    }
}
