package com.fightzhong.question_101_to_150;

import java.util.ArrayList;
import java.util.LinkedList;
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

    // 迭代解法
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if ( root != null ) {
            stack.addLast( root );
            while ( stack.size() != 0 ) {
                TreeNode node = stack.removeLast();
                result.add( node.val );

                if ( node.right != null ) {
                    stack.addLast( node.right );
                }

                if ( node.left != null ) {
                    stack.addLast( node.left );
                }
            }
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
