package com.fightzhong.question_101_to_150;

import java.util.HashMap;
import java.util.Map;

public class lc_0138_CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();
        Node cur = head;
        Node dummyHead = new Node( -1 );
        Node newCur = dummyHead;
        while ( cur != null ) {
            Node newNode = new Node( cur.val );
            oldToNew.put( cur, newNode );
            newCur.next = newNode;
            newCur = newNode;
            cur = cur.next;
        }

        cur = head;
        newCur = dummyHead.next;
        while ( cur != null && newCur != null ) {
            Node randomNode = cur.random;
            if ( randomNode != null ) {
                newCur.random = oldToNew.get( randomNode );
            }

            cur = cur.next;
            newCur = newCur.next;
        }

        return dummyHead.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
