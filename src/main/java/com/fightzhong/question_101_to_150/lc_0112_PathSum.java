package com.fightzhong.question_101_to_150;

public class lc_0112_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if ( root == null ) {
            return false;
        } else if ( root.left == null && root.right == null ) {
            return targetSum == root.val;
        } else if ( root.left == null ) {
            return hasPathSum( root.right, targetSum - root.val );
        } else if ( root.right == null ) {
            return hasPathSum( root.left, targetSum - root.val );
        }

        return hasPathSum( root.right, targetSum - root.val ) ||
                hasPathSum( root.left, targetSum - root.val );
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
