package com.fightzhong.question_101_to_150;

public class lc_0141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if ( head == null || head.next == null || head.next.next == null ) {
            return false;
        }

        ListNode node1 = head;
        ListNode node2 = head.next.next;
        while ( true ) {
            if ( node1 == null || node2 == null || node2.next == null ) {
                return false;
            } else if ( node1 == node2 ) {
                return true;
            }

            node1 = node1.next;
            node2 = node2.next.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
