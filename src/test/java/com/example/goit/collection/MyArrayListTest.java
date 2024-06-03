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

        // Test null values
        MyArrayList<Integer> list4 = new MyArrayList<>();
        list4.add(null);
        list4.add(1);
        list4.add(null);
        System.out.println("list4 after adding nulls: " + list4); // {null, 1, null}
        System.out.println("list4 size after adding nulls: " + list4.size()); // 3
        System.out.println("list4 contains null: " + list4.contains(null)); // true
        System.out.println("list4 index of null: " + list4.indexOf(null)); // 0
        System.out.println("list4 last index of null: " + list4.lastIndexOf(null)); // 2
        list4.remove(null);
        System.out.println("list4 after removing first null: " + list4); // {1, null}
        System.out.println("list4 size after removing first null: " + list4.size()); // 2

        // Test set and get with null values
        list4.set(1, null);
        System.out.println("list4 after setting null at index 1: " + list4); // {1, null}
        System.out.println("list4 get index 1: " + list4.get(1)); // null

        // Test clear and isEmpty with null values
        list4.clear();
        System.out.println("list4 after clear: " + list4); // {}
        System.out.println("list4 isEmpty: " + list4.isEmpty()); // true
    }
}
