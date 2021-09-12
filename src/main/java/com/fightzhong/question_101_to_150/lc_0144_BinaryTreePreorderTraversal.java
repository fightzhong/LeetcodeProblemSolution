package com.fightzhong.question_101_to_150;

import java.util.ArrayList;
import java.util.List;

public class lc_0144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if ( root != null ) {
            result.add( root.val );
            result.addAll( preorderTraversal( root.left ) );
            result.addAll( preorderTraversal( root.right ) );
        }

        return result;
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
