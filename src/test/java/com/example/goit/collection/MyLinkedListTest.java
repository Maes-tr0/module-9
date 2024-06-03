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

        // Test null values
        MyLinkedList<String> linkedListWithNulls = new MyLinkedList<>();
        linkedListWithNulls.add(null);
        linkedListWithNulls.add("a");
        linkedListWithNulls.add(null);
        System.out.println("LinkedList with nulls after add: " + linkedListWithNulls); // {null, a, null}
        System.out.println("LinkedList with nulls size after add: " + linkedListWithNulls.size()); // 3
        System.out.println("LinkedList with nulls contains null: " + linkedListWithNulls.contains(null)); // true
        System.out.println("LinkedList with nulls index of null: " + linkedListWithNulls.indexOf(null)); // 0
        System.out.println("LinkedList with nulls last index of null: " + linkedListWithNulls.lastIndexOf(null)); // 2
        linkedListWithNulls.remove(null);
        System.out.println("LinkedList with nulls after removing first null: " + linkedListWithNulls); // {a, null}
        System.out.println("LinkedList with nulls size after removing first null: " + linkedListWithNulls.size()); // 2

        // Test set and get with null values
        linkedListWithNulls.set(1, null);
        System.out.println("LinkedList with nulls after setting null at index 1: " + linkedListWithNulls); // {a, null}
        System.out.println("LinkedList with nulls get index 1: " + linkedListWithNulls.get(1)); // null

        // Test clear and isEmpty with null values
        linkedListWithNulls.clear();
        System.out.println("LinkedList with nulls after clear: " + linkedListWithNulls); // {}
        System.out.println("LinkedList with nulls isEmpty: " + linkedListWithNulls.isEmpty()); // true
    }
}
