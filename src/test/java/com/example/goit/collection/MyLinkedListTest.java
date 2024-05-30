package com.example.goit.collection;

import com.example.goit.collection.list.MyLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        // Test constructor
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        // Test add and size
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println("LinkedList after add: " + linkedList); // {a, b, c}
        System.out.println("LinkedList size after add: " + linkedList.size()); // 3

        // Test add by index
        linkedList.add(1, "d");
        System.out.println("LinkedList after add at index 1: " + linkedList); // {a, d, b, c}

        // Test get
        System.out.println("LinkedList get index 2: " + linkedList.get(2)); // b

        // Test set
        linkedList.set(2, "e");
        System.out.println("LinkedList after set at index 2: " + linkedList); // {a, d, e, c}

        // Test remove by index
        linkedList.remove(1);
        System.out.println("LinkedList after remove at index 1: " + linkedList); // {a, e, c}

        // Test remove by element
        linkedList.remove("e");
        System.out.println("LinkedList after remove element 'e': " + linkedList); // {a, c}

        // Test getFirst and getLast
        System.out.println("LinkedList getFirst: " + linkedList.getFirst()); // a
        System.out.println("LinkedList getLast: " + linkedList.getLast()); // c

        // Test contains
        System.out.println("LinkedList contains 'a': " + linkedList.contains("a")); // true
        System.out.println("LinkedList contains 'e': " + linkedList.contains("e")); // false

        // Test clear and isEmpty
        linkedList.clear();
        System.out.println("LinkedList after clear: " + linkedList); // {}
        System.out.println("LinkedList isEmpty: " + linkedList.isEmpty()); // true
    }
}
