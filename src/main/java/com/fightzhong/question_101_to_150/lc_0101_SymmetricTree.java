package com.fightzhong.question_101_to_150;

import java.util.LinkedList;

public class lc_0101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if ( root == null ) {
            return true;
        }

        return isSymmetric( root.left, root.right );
    }

    private boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if ( n1 == null && n2 == null ) {
            return true;
        } else if ( n1 == null || n2 == null || n1.val != n2.val ) {
            return false;
        }

        return isSymmetric(n1.left, n2.right) &&
                isSymmetric(n1.right, n2.left);
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
