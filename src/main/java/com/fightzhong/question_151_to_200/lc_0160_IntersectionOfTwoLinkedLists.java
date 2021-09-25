package com.fightzhong.question_151_to_200;

public class lc_0160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if ( headA == null || headB == null ) {
            return null;
        }

        ListNode tailA = headA;
        while ( tailA.next != null ) {
            tailA = tailA.next;
        }

        tailA.next = headB;

        ListNode a1 = headA;
        ListNode a2 = headA;
        do {
            if ( a1.next == null || a2.next == null || a2.next.next == null ) {
                tailA.next = null;
                return null;
            }

            a1 = a1.next;
            a2 = a2.next.next;
        } while (a1 != a2);

        ListNode cur = headA;
        while ( cur != a2 ) {
            cur = cur.next;
            a2 = a2.next;
        }

        tailA.next = null;
        return cur;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
