package com.wenjiehe.JavaSE;

import java.nio.BufferUnderflowException;
import java.util.Comparator;

/**
 * Created by yiyuan on 2016/10/19.
 */
public class BinaryNodeTree<E> {
    private static class BinaryNode<E> {
        E element;
        BinaryNode left;
        BinaryNode right;

        BinaryNode(E e) {
            this(e, null, null);
        }

        BinaryNode(E e, BinaryNode left, BinaryNode right) {
            this.element = e;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode<E> root;
    private Comparator<? super E> cmp;


    public BinaryNodeTree() {
        this(null);
    }

    BinaryNodeTree(Comparator c) {
        this.cmp = c;
        this.root = null;
    }

    private int myCompare(E e1, E e2) {
        if (cmp == null)
            return ((Comparable) e1).compareTo(e2);
        else
            return cmp.compare(e1, e2);

    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contain(E e) {
        return contain(e, root);
    }

    private boolean contain(E e, BinaryNode<E> p) {
        if (p == null)
            return false;
        int comp = myCompare(e, p.element);

        if (comp > 0)
            return contain(e, p.right);
        else if (comp < 0)
            return contain(e, p.left);
        else
            return true;
    }

    public E findMin() {
        if (isEmpty())
            throw new NullPointerException();
        else
            return findMin(root).element;
    }

    private BinaryNode<E> findMin(BinaryNode<E> bn) {
        if (bn == null)
            return null;
        else if (bn.left == null)
            return bn;
        return findMin(bn.left);
    }


    public E findMax() {
        if (isEmpty())
            throw new NullPointerException();
        else
            return findMax(root).element;
    }

    private BinaryNode<E> findMax(BinaryNode<E> bn) {
        if (bn != null)
            while (bn.right != null)
                bn = bn.right;
        return bn;
    }

    private BinaryNode<E> insert(E e, BinaryNode<E> bn) {
        if (bn == null)
            return new BinaryNode<E>(e, null, null);
        int compareResult;//= e.
        if (cmp == null)
            compareResult = ((Comparable) e).compareTo(bn.element);
        else
            compareResult = cmp.compare(e, bn.element);
        if (compareResult < 0)
            bn.left = insert(e, bn.left);
        else if (compareResult > 0)
            bn.right = insert(e, bn.right);
        else
            ;
        return bn;
    }
}
