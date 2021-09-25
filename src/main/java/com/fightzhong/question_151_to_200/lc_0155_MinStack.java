package com.fightzhong.question_151_to_200;

public class lc_0155_MinStack {
    Node tail;

    public lc_0155_MinStack() {

    }

    public void push(int val) {
        Node node = new Node(val, val);
        if ( tail != null ) {
            node.pre = tail;
            node.minVal = Math.min(val, tail.minVal);
        }

        tail = node;
    }

    public void pop() {
        Node temp = tail;
        tail = tail.pre;
        temp.pre = null;
    }

    public int top() {
        return tail.val;
    }

    public int getMin() {
        return tail.minVal;
    }

    static class Node {
        int val;
        int minVal;
        Node pre;

        Node (int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }
}
