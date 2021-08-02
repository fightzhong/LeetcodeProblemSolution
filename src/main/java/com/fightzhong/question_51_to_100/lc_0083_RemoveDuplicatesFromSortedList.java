package com.fightzhong.question_51_to_100;

public class lc_0083_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;

        while ( head != null ) {
            if ( head.next == null || head.next.val != head.val ) {
                cur.next = head;
                cur = cur.next;
            }

            head = head.next;
        }

        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
