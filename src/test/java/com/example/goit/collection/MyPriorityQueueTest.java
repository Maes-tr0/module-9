package com.example.goit.collection;

import com.example.goit.collection.queue.MyPriorityQueue;

public class MyPriorityQueueTest {
    public static void main(String[] args) {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();

        // Test isEmpty
        System.out.println("Queue isEmpty: " + queue.isEmpty()); // true

        // Test add and size
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Queue after add: " + queue); // {30, 20, 10}
        System.out.println("Queue size after add: " + queue.size()); // 3

        // Test peek
        System.out.println("Queue peek: " + queue.peek()); // 30

        // Test poll
        System.out.println("Queue poll: " + queue.poll()); // 30
        System.out.println("Queue after poll: " + queue); // {20, 10}
        System.out.println("Queue size after poll: " + queue.size()); // 2

        // Test clear and isEmpty
        queue.clear();
        System.out.println("Queue after clear: " + queue); // {}
        System.out.println("Queue isEmpty: " + queue.isEmpty()); // true
    }
}
