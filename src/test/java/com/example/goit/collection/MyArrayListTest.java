package com.example.goit.collection;

import com.example.goit.collection.list.MyArrayList;

public class MyArrayListTest {
    public static void main(String[] args) {
        // Test constructors
        MyArrayList<Integer> list1 = new MyArrayList<>();
        MyArrayList<Integer> list2 = new MyArrayList<>(5);
        MyArrayList<Integer> list3 = new MyArrayList<>(new Integer[]{1, 2, 3});

        // Test size and isEmpty
        System.out.println("list1 size: " + list1.size()); // 0
        System.out.println("list2 size: " + list2.size()); // 0
        System.out.println("list3 size: " + list3.size()); // 3
        System.out.println("list1 isEmpty: " + list1.isEmpty()); // true

        // Test add and contains
        list1.add(10);
        list1.add(20);
        System.out.println("list1 size after add: " + list1.size()); // 2
        System.out.println("list1 contains 10: " + list1.contains(10)); // true
        System.out.println("list1 contains 30: " + list1.contains(30)); // false

        // Test add by index
        list1.add(1, 15);
        System.out.println("list1 after add at index 1: " + list1); // {10, 15, 20}

        // Test get
        System.out.println("list1 get index 0: " + list1.get(0)); // 10

        // Test set
        list1.set(1, 25);
        System.out.println("list1 after set at index 1: " + list1); // {10, 25, 20}

        // Test remove by index
        list1.remove(1);
        System.out.println("list1 after remove at index 1: " + list1); // {10, 20}

        // Test remove by element
        list1.remove(Integer.valueOf(10));
        System.out.println("list1 after remove element 10: " + list1); // {20}

        // Test getFirst and getLast
        System.out.println("list3 getFirst: " + list3.getFirst()); // 1
        System.out.println("list3 getLast: " + list3.getLast()); // 3

        // Test clear and isEmpty
        list1.clear();
        System.out.println("list1 after clear: " + list1); // {}
        System.out.println("list1 isEmpty: " + list1.isEmpty()); // true
    }
}
