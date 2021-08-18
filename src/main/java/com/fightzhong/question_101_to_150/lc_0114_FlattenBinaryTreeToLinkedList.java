package com.fightzhong.question_101_to_150;

public class lc_0114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flatten2( root );
    }

    private TreeNode flatten2(TreeNode root) {
        if ( root == null ) {
            return null;
        }

        TreeNode leftHead = root.left;
        TreeNode rightHead = root.right;
        TreeNode leftTail = flatten2( root.left );
        TreeNode rightTail = flatten2( root.right );
        root.left = null;

        if ( leftHead == null ) {
            root.right = rightHead;
        } else {
            root.right = leftHead;
            leftTail.right = rightHead;
        }

        if ( leftTail == null && rightTail == null ) {
            return root;
        } else if ( rightTail == null ) {
            return leftTail;
        }

        return rightTail;
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
