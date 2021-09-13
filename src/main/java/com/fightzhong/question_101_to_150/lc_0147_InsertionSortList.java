package com.fightzhong.question_101_to_150;

import java.util.HashMap;
import java.util.Map;

public class lc_0147_InsertionSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode( 4 );
        head.next = new ListNode( 2 );
        head.next.next = new ListNode( 1 );
        head.next.next.next = new ListNode( 3 );

        new lc_0147_InsertionSortList().insertionSortList( head );
    }

    private Map<ListNode, ListNode> preMap = new HashMap<>();

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        fillPreMap( dummyHead );


        ListNode cur = head;
        while ( cur != null ) {
            ListNode nextCur = cur.next;
            ListNode pre = preMap.get( cur );

            boolean find = false;
            while ( cur.val < pre.val && pre != dummyHead ) {
                pre = preMap.get( pre );
                find = true;
            }

            pre = pre.next;
            if ( find ) {
                ListNode prepre = preMap.get( pre );
                ListNode prenext = pre.next;
                ListNode curpre = preMap.get( cur );
                ListNode curnext = cur.next;
                curpre.next = curnext;
                preMap.put( curnext, curpre );

                prepre.next = cur;
                cur.next = pre;
                preMap.put( cur, prepre );
                preMap.put( pre, cur );
            }

            cur = nextCur;
        }

        return dummyHead.next;
    }

    private void fillPreMap(ListNode node) {
        ListNode pre = node;
        ListNode cur = node.next;
        while ( cur != null ) {
            preMap.put( cur, pre );
            pre = cur;
            cur = cur.next;
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
