package com.fightzhong.question_51_to_100;

public class lc_0086_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode minDummyHead = new ListNode();
        ListNode maxDummyHead = new ListNode();
        ListNode minCur = minDummyHead;
        ListNode maxCur = maxDummyHead;

        while ( head != null ) {
            if ( head.val < x ) {
                minCur.next = head;
                minCur = minCur.next;
            } else {
                maxCur.next = head;
                maxCur = maxCur.next;
            }
            head = head.next;
        }

        minCur.next = maxDummyHead.next;
        maxCur.next = null;

        return minDummyHead.next;
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
