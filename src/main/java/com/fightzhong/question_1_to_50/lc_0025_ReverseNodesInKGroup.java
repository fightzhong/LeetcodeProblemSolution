package com.fightzhong.question_1_to_50;

public class lc_0025_ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class ReverseInfo {
        private ListNode head;

        private ListNode tail;

        private int nodeCount;

        public ReverseInfo(ListNode head, ListNode tail, int nodeCount) {
            this.head = head;
            this.tail = tail;
            this.nodeCount = nodeCount;
        }
    }

    public static void main(String[] args) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        for ( int i = 1; i <= 8; i ++ ) {
            cur.next = new ListNode( i );
            cur = cur.next;
        }

        new lc_0025_ReverseNodesInKGroup().reverseKGroup( dummyHead.next, 3 );
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode preGroupTail = dummyHead;
        while ( head != null ) {
            ReverseInfo reverseInfo = reverseInfo( head, k );
            // 满足一组
            if ( reverseInfo.nodeCount == k ) {
                preGroupTail.next = reverseInfo.head;
                preGroupTail = reverseInfo.tail;
                head = preGroupTail.next;
            } else {
                reverseInfo = reverseInfo( reverseInfo.head, reverseInfo.nodeCount );
                preGroupTail.next = reverseInfo.head;
                break;
            }
        }

        return dummyHead.next;
    }

    private ReverseInfo reverseInfo (ListNode head, int count) {
        ListNode tail = null;
        ListNode newHead = null;
        int nodeCount = 0;
        while ( count > 0 && head != null ) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;

            if ( tail == null ) {
                tail = newHead;
            }

            count --;
            nodeCount ++;
        }

        if ( tail != null ) {
            tail.next = head;
        }

        return new ReverseInfo( newHead, tail, nodeCount );
    }
}
