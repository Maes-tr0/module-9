package com.example.goit.collection.list;

import java.util.StringJoiner;

public class MyStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public MyStack() {
        top = null;
        size = 0;
    }

    public MyStack(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size = 1;
    }

    public boolean contains(T data) {
        Node<T> current = top;
        while (current != null) {
            if (data.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T remove(T data) {
        if (top == null) {
            return null;
        } else if (top.data.equals(data)) {
            return pop();
        } else {
            Node<T> current = top;
            while (current.next != null) {
                if(!current.next.data.equals(data)){
                    current = current.next;
                }
            }
            if (current.next != null) {
                T removedData = current.next.data;
                current.next = current.next.next;
                size--;
                return removedData;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        Node<T> current = top;
        while (current != null) {
            sj.add(String.valueOf(current.data));
            current = current.next;
        }
        return sj.toString();
    }
}
