package com.example.goit.collection.map;

public interface MyMap<K, V> {
    int size();
    boolean isEmpty();
    void put(K key, V value);
    V get(K key);
    V remove(K key);
}
