package com.fightzhong.question_51_to_100;

public class lc_0082_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if( head == null ) {
            return null;
        }

        ListNode dummyHead = new ListNode();
        ListNode newCur = dummyHead;

        ListNode dummyHead2 = new ListNode();
        // 这个是因为leetcode上题目有一个提示是: -100 <= Node.val <= 100, 如果没有这个提示, 那么只需要将这个虚拟头节点的值设置为跟第一个节点不一样即可, 这里需要考虑整型溢出的情况
        dummyHead2.val = 200;
        dummyHead2.next = head;
        ListNode pre = dummyHead2;
        ListNode cur = head;
        while ( cur != null ) {
            if ( pre.val != cur.val && ( cur.next == null || cur.val != cur.next.val ) ) {
                newCur.next = cur;
                newCur = newCur.next;
            }

            pre = cur;
            cur = cur.next;
        }

        newCur.next = null;
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
