package com.example.goit.collection.map;

import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(final K key, final V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "\"" + key + "\": \"" + value + "\"";
        }
    }

    private final static int DEFAULT_INITIAL_CAPACITY = 16;
    private Entry<K, V>[] table;
    private int size;

    public MyHashMap() {
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    /* First Realization
    *
    *   @Override
    public void put(K key, V value) {
        int indexInHashMap = getIndex(getHashCode(key));
        if(table[indexInHashMap] == null) {
            table[indexInHashMap] = new Entry<>(key, value);
        } else {
            Entry<K, V> currentEntry = table[indexInHashMap];
            if(currentEntry.next == null && currentEntry.key.equals(key) && getHashCode(currentEntry.key) == getHashCode(key)){
                currentEntry.value = value;
                return;
            } else {
                while(currentEntry.next != null) {
                    if (getHashCode(key) == getHashCode(currentEntry.key) && currentEntry.key.equals(key)) {
                        currentEntry.value = value;
                        return;
                    }
                    currentEntry = currentEntry.next;
                }
                currentEntry.next = new Entry<>(key, value);
            }
        }
        size++;
    }
    *
    * */


    @Override
    public void put(K key, V value) {
        int indexInHashMap = getIndex(getHashCode(key));
        Entry<K, V> currentEntry = table[indexInHashMap];

        if (currentEntry == null) {
            table[indexInHashMap] = new Entry<>(key, value);
        } else {
            while (true) {
                if (getHashCode(key) == getHashCode(currentEntry.key) && Objects.equals(currentEntry.key, key)) {
                    currentEntry.value = value;
                    return;
                }
                if (currentEntry.next == null) {
                    break;
                }
                currentEntry = currentEntry.next;
            }
            currentEntry.next = new Entry<>(key, value);
        }
        size++;
    }

    private int getIndex(int hashCode) {
        return Math.abs(hashCode % table.length);
    }

    private int getHashCode(K key) {
        return key == null ? 0 : key.hashCode();
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
    public V get(K key) {
        int indexInHashMap = getIndex(getHashCode(key));
        Entry<K, V> currentEntry = table[indexInHashMap];

        while (currentEntry != null) {
            if (Objects.equals(currentEntry.key, key)) {
                return currentEntry.value;
            }
            currentEntry = currentEntry.next;
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int indexInHashMap = getIndex(getHashCode(key));
        Entry<K, V> currentEntry = table[indexInHashMap];
        Entry<K, V> previousEntry = null;

        while (currentEntry != null) {
            if (Objects.equals(currentEntry.key, key)) {
                if (previousEntry == null) {
                    table[indexInHashMap] = currentEntry.next;
                } else {
                    previousEntry.next = currentEntry.next;
                }
                size--;
                return currentEntry.value;
            }
            previousEntry = currentEntry;
            currentEntry = currentEntry.next;
        }

        return null;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                stringJoiner.add(entry.toString());
                entry = entry.next;
            }
        }
        return stringJoiner.toString();
    }
}
