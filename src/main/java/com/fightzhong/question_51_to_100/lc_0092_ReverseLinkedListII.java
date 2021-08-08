package com.fightzhong.question_51_to_100;

public class lc_0092_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if ( left == right ) {
            return head;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode leftNodePre = dummyHead;
        ListNode leftNode = head;
        ListNode rightNode = null;
        ListNode rightNodeNext = null;
        ListNode pre = dummyHead;

        int i = 1;
        while ( head != null ) {
            if ( i == left ) {
                leftNodePre = pre;
                leftNode = head;
            } else if ( i == right ) {
                rightNode = head;
                rightNodeNext = head.next;
                break;
            }

            pre = head;
            head = head.next;
            i++;
        }

        leftNodePre.next = null;
        rightNode.next = null;

        ListNode tail = null;
        ListNode cur = leftNode;
        while ( cur != null ) {
            ListNode next = cur.next;
            cur.next = tail;
            tail = cur;
            cur = next;
        }

        leftNodePre.next = rightNode;
        leftNode.next = rightNodeNext;

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
