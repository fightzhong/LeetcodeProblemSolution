package com.fightzhong.question_101_to_150;

import java.util.LinkedList;

public class lc_0116_PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        connect( root, null, null );
        return root;
    }

    public void connect(Node cur, Node parent, Node parentNext) {
        if ( cur == null ) {
            return;
        }

        if ( parent != null ) {
            if ( cur == parent.left ) {
                cur.next = parent.right;
            } else {
                cur.next = parentNext == null ? null : parentNext.left;
            }
        }

        connect( cur.left, cur, cur.next );
        connect( cur.right, cur, cur.next );
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
