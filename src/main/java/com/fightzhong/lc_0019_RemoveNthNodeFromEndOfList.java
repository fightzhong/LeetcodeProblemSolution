package com.fightzhong;

import java.util.ArrayList;
import java.util.List;

public class lc_0019_RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        List<ListNode> cache = new ArrayList<>();
        cache.add( dummyHead );
        while ( head != null ) {
            cache.add(head);
            head = head.next;
        }

        int index = cache.size() - n;
        ListNode pre = cache.get( index - 1 );
        pre.next = index + 1 >= cache.size() ? null : cache.get( index + 1 );

        return dummyHead.next;
    }
}
