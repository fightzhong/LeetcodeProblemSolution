package com.fightzhong.question_51_to_100;

public class lc_0100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null ) {
            return true;
        } else if ( p == null || q == null ) {
            return false;
        }

        if ( p.val != q.val ) {
            return false;
        }

        return isSameTree( p.left, q.left ) &&
                isSameTree( p.right, q.right );

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
