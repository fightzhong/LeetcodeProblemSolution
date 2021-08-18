package com.fightzhong.question_101_to_150;

public class lc_0110_BalancedBinaryTree {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if ( root == null ) {
            return true;
        }

        getHeight(root);

        return isBalanced;
    }

    private int getHeight(TreeNode cur) {
        if ( cur == null ) {
            return 0;
        }

        int left = getHeight( cur.left );
        int right = getHeight( cur.right );
        if ( Math.abs( left - right ) > 1 ) {
            isBalanced = false;
        }

        return Math.max( left, right ) + 1;
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
