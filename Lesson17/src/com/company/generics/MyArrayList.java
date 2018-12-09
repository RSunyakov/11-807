package com.company.generics;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private T[] elements;
    private int count = 0;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private static final double EXTENSION_COEF = 1.5;


    public MyArrayList() {
       this.elements = (T[]) new Object[DEFAULT_CAPACITY];
       this.capacity = DEFAULT_CAPACITY;
    }

    public void add(T e) {
        if (capacity == count) {
            grow();
        }
        elements[count] = e;
        count++;
    }

    private void grow() {
        int newCapacity = (int) (capacity * EXTENSION_COEF);
        T[] newElements = (T[]) new Object[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newElements[i] = elements[i];
        }
        capacity = newCapacity;
        elements = newElements;
    }

    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("No such index");
        }
        return elements[index];
    }

    //число элементов в списке
    int size() {
        return count;
    }

    //есть ли в списке такой элемент
    boolean contains(T value) {
        boolean ContainsCheck = false;
        for (int i = 0; i < count; i++) {
            if (elements[i].equals(value)) {
                ContainsCheck = true;
                break;
            }
        }
        return ContainsCheck;
    }

    //удаление элемента по индекс (со смещением элементов влево)
    void remove(int index) {
        int ArrayLength = elements.length;
        for (int i = index; i < ArrayLength - 1; i++) {
            elements[i] = elements[i+1];
            ArrayLength--;
        }
    }

    //возвращает все элементы из списка в виде массива
    T[] toArray() {

        return Arrays.copyOf(elements, size());
    }

    //добавление всех элементов из списка list в данный список(в конец)
    void addAll(MyArrayList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            if (capacity == count) {
                grow();
            }
            add(list.get(i));
        }
    }

    //добавление всех элементов из списка list в данный список
    //начиная с позиции index
    /*void addAll(MyArrayList<T> list, int index) {
        int newCapacity = elements.length + list.capacity;
        T[] newElements = (T[]) new Object[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newElements[i] = elements[i];
        }
        capacity = newCapacity;

        T[] tmp = (T[]) new Object[list.size() + index];
        for (int i = index; i < size() ; i++) {
            for (int j = 0; j < list.size(); j++) {
                tmp[j] = elements[i];
            }
            for (int k = 0; k < list.size(); k++) {
                elements[i] = list.get(k);
            }
        }
        T[] tmpLast = (T[]) new Object[list.size() - index];
        for (int i = list.size() + index; i < size(); i++) {
            for (int k = 0; k < list.size() - index; k++) {
                tmpLast[k] = elements[i];
            }
        }
        for (int i = list.size() + index; i < size() ; i++) {
            for (int k = 0; k < list.size(); k++) {
                elements[i] = tmp[k];
            }
        }
        for (int i = size(); i <; i++) {

        }
            for (int i = index; i < size() ; i++) {
                if (elements[i] == null) {
                    remove(i);
                }
        }
    }*/

    public Iterator<T> iterator() {
        return new MyIter();
    }

    public class MyIter implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < count;
        }

        @Override
        public T next() {
            return elements[currentIndex++];
        }
    }
}
