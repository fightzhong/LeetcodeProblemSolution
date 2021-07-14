package com.fightzhong.question_1_to_50;

public class lc_0024_SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if ( head == null || head.next == null ) {
            return head;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;

        while ( cur != null && cur.next != null ) {
            ListNode n1 = cur.next.next;
            pre.next = cur.next;
            cur.next = n1;
            pre.next.next = cur;

            pre = cur;
            cur = n1;
        }

        return dummyHead.next;
    }
}
