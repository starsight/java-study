package com.wenjiehe.Algorithm;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by yiyuan on 2016/10/17.
 */
public class MyArrayList<E> implements Iterable<E> {

    private static final int DEFAUT_CAPACITY = 10;
    private int size;
    private E[] items;

    MyArrayList() {
        clear();
    }

    public void clear() {
        size = 0;
        ensureCapacity(DEFAUT_CAPACITY);
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < size)
            return;
        E[] old = items;
        //items = new E[newCapacity];
        items = (E[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++)
            items[i] = old[i];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public E get(int i) {
        if (i < 0 || i >= size())
            throw new ArrayIndexOutOfBoundsException();
        return items[i];
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();
        E old = items[index];
        items[index] = e;
        return old;
    }

    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    public void add(int index, E e) {
        if (items.length == size())
            ensureCapacity(2 * size() + 1);
        for (int i = size(); i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = e;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();
        E old = items[index];
        for (int i = index; i < size() - 1; i++)
            items[index] = items[index + 1];
        size--;
        return old;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListInterator();
    }

    class ArrayListInterator implements Iterator<E> {

        private int current =0;
        @Override
        public boolean hasNext() {
            return (current<size());
        }

        @Override
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return items[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

}
