package com.wenjiehe.JZOffer;

/**
 * Created by yiyuan on 17/12/11.
 */
public class OfferTest {
    public static void main(String[] args) {
        ListNode treeNode1 = new ListNode(1);
        ListNode treeNode2 = new ListNode(2);
        ListNode treeNode3 = new ListNode(3);
        treeNode1.next=treeNode2;
        treeNode2.next =treeNode3;

        OfferTest offerTest =new OfferTest();
        offerTest.nodeTest(treeNode1);
    }

    public ListNode nodeTest(ListNode treeNode){
        treeNode.val=4;
        treeNode = treeNode.next;
        return treeNode;
    }


}
