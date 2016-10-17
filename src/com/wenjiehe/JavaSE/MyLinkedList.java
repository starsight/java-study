package com.wenjiehe.JavaSE;

import java.util.Iterator;

/**
 * Created by yiyuan on 2016/10/17.
 */
public class MyLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int modCount = 0;

    private static class Node<E> {
        public E data;
        public Node<E> next;
        public Node<E> prev;


        public Node(E d, Node<E> pre, Node<E> ne) {
            data = d;
            prev = pre;
            next = ne;
        }
    }

    public MyLinkedList() {
        clear();
    }

    public void clear() {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    public void add(int index, E e) {
        addBefore(getNode(index), e);
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public E set(int index, E e) {
        Node<E> node = getNode(index);
        E old = node.data;
        node.data = e;
        return old;
    }

    public E remove(int index) {
        return remove(getNode(index));
    }

    private void addBefore(Node<E> node, E e) {

    }

    private E remove(Node<E> e) {

    }

    private Node<E> getNode(int index) {

    }

    public class linkedListIterator implements Iterator{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }

}
