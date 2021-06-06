package com.fightzhong;

public class lc_0002_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;

        int nextAdd = 0;
        while ( l1 != null || l2 != null ) {
            int l1Value = 0;
            if ( l1 != null ) {
                l1Value = l1.val;
                l1 = l1.next;
            }

            int l2Value = 0;
            if ( l2 != null ) {
                l2Value = l2.val;
                l2 = l2.next;
            }

            int sum = nextAdd + l1Value + l2Value;
            cur.next = new ListNode( sum % 10 );
            cur = cur.next;

            nextAdd = sum / 10;
        }

        if ( nextAdd != 0 ) {
            cur.next = new ListNode( nextAdd );
        }

        return dummyHead.next;
    }
}


