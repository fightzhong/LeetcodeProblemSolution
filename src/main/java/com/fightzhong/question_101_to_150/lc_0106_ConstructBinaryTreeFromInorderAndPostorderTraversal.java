package com.fightzhong.question_101_to_150;

import java.util.HashMap;
import java.util.Map;

public class lc_0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> valueToInorderIndex = new HashMap<>();
        for ( int i = 0; i < inorder.length; i ++ ) {
            valueToInorderIndex.put( inorder[i], i );
        }

        return buildTree( inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, valueToInorderIndex );
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inLeft, int inRight,
                               int postLeft, int postRight,
                               Map<Integer, Integer> valueToInorderIndex) {
        if ( postLeft > postRight || inLeft > inRight ) {
            return null;
        }

        int curValue = postorder[postRight];
        int inorderIndex = valueToInorderIndex.get( curValue );
        TreeNode curNode = new TreeNode( curValue );

        curNode.left = buildTree( inorder, postorder, inLeft, inorderIndex - 1, postLeft,  postLeft + (inorderIndex - inLeft) - 1, valueToInorderIndex );
        curNode.right = buildTree( inorder, postorder, inorderIndex + 1, inRight, postRight - (inRight - inorderIndex), postRight - 1, valueToInorderIndex );

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
