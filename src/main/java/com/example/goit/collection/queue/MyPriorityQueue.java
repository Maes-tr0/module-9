package com.example.goit.collection.queue;

import java.util.StringJoiner;

public class MyPriorityQueue<T> implements MyQueue<T> {
    private Node<T> head;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public MyPriorityQueue() {
        head = null;
        size = 0;
    }

    public MyPriorityQueue(T data) {
        head = new Node<>(data);
        size = 1;
    }

    @Override
    public void add(T item) {
        offer(item);
    }

    @Override
    public void offer(T item) {
        if (head == null) {
            head = new Node<>(item);
        } else {
            Node<T> newNode = new Node<>(item);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public T poll() {
        if (head == null) {
            return null;
        }
        T item = peek();
        head = head.next;
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        Node<T> node = head;
        while (node != null) {
            joiner.add(node.data.toString());
            node = node.next;
        }
        return joiner.toString();
    }
}
