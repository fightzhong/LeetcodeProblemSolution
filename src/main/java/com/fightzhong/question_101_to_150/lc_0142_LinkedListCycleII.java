package com.fightzhong.question_101_to_150;

public class lc_0142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        do {
            if ( n1 == null || n2 == null || n2.next == null ) {
                return null;
            }

            n1.val = 0;
            n2.val = 0;

            n1 = n1.next;
            n2 = n2.next.next;
        } while ( n1 != n2 );

        n1 = head;
        while ( n1 != n2 ) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
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
