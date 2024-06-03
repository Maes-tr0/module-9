package com.example.goit.collection.list;

import java.util.Objects;
import java.util.StringJoiner;

public class MyLinkedList<T> implements MyList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T item) {
            this.data = item;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public MyLinkedList(T item) {
        Node<T> newNode = new Node<>(item);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        Objects.checkIndex(index, size);
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            add(item);
            return;
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode;
            newNode.prev = currentNode.prev;
            currentNode.prev.next = newNode;
            currentNode.prev = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        Objects.checkIndex(index, size);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = item;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T item) {
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(currentNode.data, item)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        int index = -1;
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(currentNode.data, item)) {
                index = i;
            }
            currentNode = currentNode.next;
        }
        return index;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        Node<T> currentNode = head;
        T data;
        if (index == 0) {
            data = head.data;
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            data = tail.data;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            data = currentNode.data;
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }
        size--;
        return data;
    }

    @Override
    public T remove(T item) {
        int index = indexOf(item);
        if (index == -1) {
            return null;
        }
        return remove(index);
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.data;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            array[i] = currentNode.data;
            currentNode = currentNode.next;
        }
        return array;
    }

    @Override
    public String toString() {
        StringJoiner jr = new StringJoiner(", ", "{", "}");
        Node<T> currentNode = head;
        while (currentNode != null) {
            jr.add(String.valueOf(currentNode.data));
            currentNode = currentNode.next;
        }
        return jr.toString();
    }
}
