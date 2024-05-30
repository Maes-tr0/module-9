package com.example.goit.collection.list;

public interface MyList<T> {
    void add(T item);
    void add(int index, T item);
    void set(int index, T item);
    void clear();
    int size();
    int indexOf(T item);
    int lastIndexOf(T item);
    boolean isEmpty();
    boolean contains(T item);
    T remove(int index);
    T remove(T item);
    T get(int index);
    T getFirst();
    T getLast();
    Object[] toArray();
}
