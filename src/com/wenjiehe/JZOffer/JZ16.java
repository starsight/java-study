package com.wenjiehe.JZOffer;

/**
 * Created by Administrator on 2017/12/5.
 */
public class JZ16 {

    ListNode x = null;
    int count = 0;

    public ListNode ReverseList(ListNode head) {
        ListNode list = null;

        if (head == null)
            return null;
        count++;
        if (head.next != null) {

            list = ReverseList(head.next);
            head.next=null;
            list.next = head;
            list=list.next;
        } else {
            list = head;
            x = list;
        }
        count--;
        if (count == 0)
            return x;
        else
            return list;

    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(0);
        ListNode head =listNode;
        for (int i = 0; i <5 ; i++) {
            listNode.next=new ListNode(i+1);
            listNode=listNode.next;
        }

        JZ16 jz16 =new JZ16();
        jz16.ReverseList(head);
        ;
    }
}
