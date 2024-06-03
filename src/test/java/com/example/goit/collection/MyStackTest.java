package com.example.goit.collection;

import com.example.goit.collection.list.MyStack;

public class MyStackTest {
    public static void main(String[] args) {
        // Test constructor
        MyStack<Integer> stack = new MyStack<>();

        // Test isEmpty
        System.out.println("Stack isEmpty: " + stack.isEmpty()); // true

        // Test push and size
        stack.push(10);
        stack.push(20);
        System.out.println("Stack after push: " + stack); // {20, 10}
        System.out.println("Stack size after push: " + stack.size()); // 2

        // Test contains
        System.out.println("Stack contains 10: " + stack.contains(10)); // true
        System.out.println("Stack contains 30: " + stack.contains(30)); // false

        // Test peek
        System.out.println("Stack peek: " + stack.peek()); // 20

        // Test pop
        System.out.println("Stack pop: " + stack.pop()); // 20
        System.out.println("Stack after pop: " + stack); // {10}
        System.out.println("Stack size after pop: " + stack.size()); // 1

        // Test remove
        stack.push(30);
        System.out.println("Stack after push 30: " + stack); // {30, 10}
        System.out.println("Stack remove 10: " + stack.remove(10)); // 10
        System.out.println("Stack after remove 10: " + stack); // {30}
        System.out.println("Stack size after remove: " + stack.size()); // 1

        // Test toString
        System.out.println("Stack toString: " + stack); // {30}

        // Test with null values
        MyStack<Integer> stackWithNulls = new MyStack<>();
        stackWithNulls.push(null);
        stackWithNulls.push(10);
        stackWithNulls.push(null);
        System.out.println("Stack with nulls after push: " + stackWithNulls); // {null, 10, null}
        System.out.println("Stack with nulls size after push: " + stackWithNulls.size()); // 3

        System.out.println("Stack with nulls contains null: " + stackWithNulls.contains(null)); // true

        System.out.println("Stack with nulls pop: " + stackWithNulls.pop()); // null
        System.out.println("Stack with nulls after pop: " + stackWithNulls); // {10, null}
        System.out.println("Stack with nulls size after pop: " + stackWithNulls.size()); // 2

        System.out.println("Stack with nulls remove null: " + stackWithNulls.remove(null)); // null
        System.out.println("Stack with nulls after remove null: " + stackWithNulls); // {10}
        System.out.println("Stack with nulls size after remove null: " + stackWithNulls.size()); // 1

        stackWithNulls.clear();
        System.out.println("Stack with nulls after clear: " + stackWithNulls); // {}
        System.out.println("Stack with nulls isEmpty: " + stackWithNulls.isEmpty()); // true
    }
}
