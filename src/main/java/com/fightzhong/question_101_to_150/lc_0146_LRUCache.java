package com.fightzhong.question_101_to_150;

import java.util.HashMap;
import java.util.Map;

public class lc_0146_LRUCache {
    private Map<Integer, KeyNode> map = new HashMap<>();

    private final int capacity;

    private int size;

    private final KeyNode head = new KeyNode(-1, -1);

    private KeyNode tail = head;

    public lc_0146_LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        KeyNode node = map.get( key );
        if ( node == null ) {
            return -1;
        }

        if ( tail != node ) {
            KeyNode pre = node.pre;
            KeyNode next = node.next;
            pre.next = next;
            next.pre = pre;

            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }

        return node.val;
    }

    public void put(int key, int value) {
        KeyNode node = map.get( key );
        if ( node != null ) {
            node.val = value;
            get( key );
            return;
        }

        node = new KeyNode( key, value, tail, null );
        tail.next = node;
        tail = node;

        map.put( key, node );
        size ++;

        if ( size > capacity ) {
            KeyNode temp = head.next;
            head.next = temp.next;
            head.next.pre = head;

            temp.pre = null;
            temp.next = null;
            map.remove( temp.key );
            size --;
        }
    }

    public static class KeyNode {
        public Integer key;

        public Integer val;

        public KeyNode pre;

        public KeyNode next;

        public KeyNode (Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }

        public KeyNode (Integer key, Integer val, KeyNode pre, KeyNode next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}
