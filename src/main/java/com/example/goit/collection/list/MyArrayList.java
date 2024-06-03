package com.example.goit.collection.list;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class MyArrayList<T> implements MyList<T> {
    private T[] dataElements;
    private int size;

    public MyArrayList() {
        dataElements = (T[]) new Object[10];
        size = 0;
    }

    public MyArrayList(int size) {
        dataElements = (T[]) new Object[size];
        size = 0;
    }

    public MyArrayList(T[] elements) {
        dataElements = Arrays.copyOf(elements, elements.length);
        size = elements.length;
    }

    private void modifySizeData(){
        if(size == dataElements.length){
            dataElements = Arrays.copyOf(dataElements, size + (size / 2) + 1);
        }
    }

    @Override
    public void add(T item) {
        modifySizeData();
        dataElements[size++] = item;
    }

    @Override
    public void add(int index, T item) {
        Objects.checkIndex(index, size);
        modifySizeData();
        for(int i = size; i > index; i--){
            dataElements[i] = dataElements[i - 1];
        }
        dataElements[index] = item;
        size++;
    }

    @Override
    public void set(int index, T item) {
        Objects.checkIndex(index, size);
        dataElements[index] = item;
    }

    @Override
    public void clear() {
        dataElements = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(dataElements[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(dataElements[i], item)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(dataElements[i], item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement = dataElements[index];
        for (int i = index; i < size - 1; i++) {
            dataElements[i] = dataElements[i + 1];
        }
        dataElements[--size] = null;
        return removedElement;
    }

    @Override
    public T remove(T item) {
        int removeIndex = indexOf(item);
        if (removeIndex == -1) {
            return null;
        }
        return remove(removeIndex);
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return dataElements[index];
    }

    @Override
    public T getFirst() {
        return dataElements[0];
    }

    @Override
    public T getLast() {
        return dataElements[size - 1];
    }

    @Override
    public Object[] toArray() {
        Object[] array = Arrays.copyOf(dataElements, size);
        return array;
    }

    @Override
    public String toString() {
        StringJoiner jr = new StringJoiner(", ", "{", "}");
        for (int i = 0; i < size; i++) {
            jr.add(String.valueOf(dataElements[i]));
        }
        return jr.toString();
    }
}
