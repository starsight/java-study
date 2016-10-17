package com.wenjiehe.JavaSE;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by yiyuan on 2016/10/17.
 */
public class MyLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int modCount = 0;//operate linkedlist count since created

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
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);
        head.next = tail;

        size = 0;
        modCount++;
    }

    @Override
    public Iterator<E> iterator() {
        return new linkedListIterator();
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
        Node<E> obj = new Node<>(e, node.prev, node);
        node.prev.next = obj;
        node.prev = obj;
        size++;
        modCount++;
    }

    private E remove(Node<E> e) {
        e.prev.next = e.next;
        e.next.prev = e.prev;
        size--;
        modCount++;
        return e.data;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        Node<E> nodetmp;
        if (index < (size() / 2)) {
            nodetmp = head.next;
            for (int i = 0; i < index; i++) {
                nodetmp = nodetmp.next;
            }
        } else {//add node before current node,so nodetmp does not equal tailnext while nodetmp equals head.next
            nodetmp = tail;
            for (int i = size(); i > index; i--)
                nodetmp = nodetmp.prev;
        }

        return nodetmp;
    }

    private class linkedListIterator implements Iterator<E> {

        private Node<E> current = head.next;
        private int expectedModCount = modCount;
        private boolean oktToRemove = false;

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public E next() {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();
            if (!hasNext())
                throw new NoSuchElementException();
            E next = current.data;
            current = current.next;
            oktToRemove = true;
            return next;

        }

        public void remove(){
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();
            if (!oktToRemove)
                throw new IllegalStateException();
            MyLinkedList.this.remove(current.prev);
            oktToRemove =false;
            expectedModCount++;
        }
    }

}
