package com.fightzhong.question_101_to_150;

public class lc_0129_SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        sumNumbers( root, 0 );
        return total;
    }

    private int total = 0;

    private void sumNumbers(TreeNode cur, int old) {
        if ( cur == null ) {
            return;
        }

        int curTotal = old * 10 + cur.val;
        if ( cur.left == null && cur.right == null ) {
            total += curTotal;
        }

        sumNumbers( cur.left, curTotal );
        sumNumbers( cur.right, curTotal );
    }


    public class TreeNode {
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
