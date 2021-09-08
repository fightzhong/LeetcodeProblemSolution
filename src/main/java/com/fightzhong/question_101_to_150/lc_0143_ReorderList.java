package com.fightzhong.question_101_to_150;

public class lc_0143_ReorderList {
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while ( cur != null ) {
            count ++;
            cur = cur.next;
        }

        int nextNodeIndex = count % 2 == 0 ? count / 2 + 1 : count / 2 + 2;

        ListNode pre = null;
        cur = head;
        int curIndex = 1;
        while ( curIndex != nextNodeIndex ) {
            pre = cur;
            cur = cur.next;
            curIndex ++;
        }

        if ( pre != null ) {
            pre.next = null;
        }

        ListNode node1 = head;
        ListNode node2 = reverse( cur );
        ListNode newNode = new ListNode();
        boolean b = true;
        int curCount = 1;
        while ( curCount <= count ) {
            if ( b ) {
                newNode.next = node1;
                node1 = node1.next;
            } else {
                newNode.next = node2;
                node2 = node2.next;
            }

            b = !b;
            newNode = newNode.next;
            curCount ++;
        }
    }

    private ListNode reverse (ListNode node) {
        ListNode head = null;
        while ( node != null ) {
            ListNode temp = node.next;
            node.next = head;
            head = node;
            node = temp;
        }

        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
