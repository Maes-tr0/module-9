package com.example.goit.collection.queue;

public interface MyQueue<T> {
    boolean isEmpty();
    int size();
    void clear();
    T peek();
    T poll();
    void offer(T element);
    void add(T element);

}
