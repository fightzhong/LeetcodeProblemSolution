package com.fightzhong.question_1_to_50;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc_0023_MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for ( ListNode node: lists ) {
            while ( node != null ) {
                priorityQueue.add( node );
                node = node.next;
            }
        }

        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while ( priorityQueue.size() != 0 ) {
            cur.next = priorityQueue.poll();
            cur = cur.next;
        }

        cur.next = null;
        return dummyHead.next;
    }
}
