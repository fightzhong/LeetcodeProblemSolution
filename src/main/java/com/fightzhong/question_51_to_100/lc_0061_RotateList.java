package com.fightzhong.question_51_to_100;

public class lc_0061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if ( head == null ) {
            return head;
        }

        ListNode cur = head;
        ListNode tail = head;
        int count = 0;
        while ( cur != null ) {
            tail = cur;
            cur = cur.next;
            count ++;
        }

        int targetCount = k % count;
        if ( targetCount == 0 ) {
            return head;
        } else {
            targetCount = count - targetCount;
            ListNode cHead = head;
            ListNode cTail = head;
            int cCount = 1;
            while ( cCount != targetCount ) {
                cTail = cTail.next;
                cCount ++;
            }

            head = cTail.next;
            cTail.next = null;
            tail.next = cHead;

            return head;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
