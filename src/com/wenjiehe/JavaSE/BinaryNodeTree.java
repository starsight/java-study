package com.wenjiehe.JavaSE;

/**
 * Created by yiyuan on 2016/10/19.
 */
public class BinaryNodeTree <E extends Comparable<? super E>> {
    private static class BinaryNode<E>{
        E element;
        BinaryNode left;
        BinaryNode right;

        BinaryNode(E e){
            this(e,null,null);
        }

        BinaryNode(E e, BinaryNode left, BinaryNode right){
            this.element = e;
            this.left = left;
            this.right = right;
        }
    }

    BinaryNode root;
    private boolean contain(E e,BinaryNode<E> p){
        if(p==null)
            return false;
        int comp = e.compareTo(p.element);

        if(comp>0)
            return  contain(e,p.right);
        else if(comp<0)
            return contain(e,p.left);
        else
            return true;
            //BinaryNode bn = new BinaryNode(e);
    }
}
