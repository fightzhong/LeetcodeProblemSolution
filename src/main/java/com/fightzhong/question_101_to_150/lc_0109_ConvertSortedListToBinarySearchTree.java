package com.fightzhong.question_101_to_150;

import java.util.HashMap;
import java.util.Map;

public class lc_0109_ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        int totalCount = 0;
        Map<Integer, Integer> indexToValue = new HashMap<>();
        while ( head != null ) {
            indexToValue.put( totalCount ++, head.val );
            head = head.next;
        }

        return sortedListToBST( indexToValue, 0, totalCount - 1 );
    }

    private TreeNode sortedListToBST(Map<Integer, Integer> indexToValue, int left, int right) {
        if ( left > right ) {
            return null;
        }

        int mid = left + ( right - left ) / 2;
        Integer value = indexToValue.get( mid );
        TreeNode cur = new TreeNode( value );
        cur.left = sortedListToBST( indexToValue, left, mid - 1 );
        cur.right = sortedListToBST( indexToValue, mid + 1, right );
        return cur;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
