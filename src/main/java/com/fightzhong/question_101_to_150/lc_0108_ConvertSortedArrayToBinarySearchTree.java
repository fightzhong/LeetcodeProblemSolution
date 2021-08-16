package com.fightzhong.question_101_to_150;

public class lc_0108_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST( nums, 0, nums.length - 1 );
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if ( left > right ) {
            return null;
        }

        int mid = left + ( right - left ) / 2;
        TreeNode curNode = new TreeNode( nums[mid] );
        curNode.left = sortedArrayToBST( nums, left, mid - 1 );
        curNode.right = sortedArrayToBST( nums, mid + 1, right );

        return curNode;
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
