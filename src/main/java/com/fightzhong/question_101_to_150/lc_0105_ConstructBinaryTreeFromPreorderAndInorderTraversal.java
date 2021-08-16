package com.fightzhong.question_101_to_150;

import java.util.HashMap;
import java.util.Map;

public class lc_0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ( preorder.length == 0 ) {
            return null;
        }

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for ( int i = 0; i < inorder.length; i ++ ) {
            inorderMap.put( inorder[i], i );
        }

        return buildTree( preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1, inorderMap );
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight, Map<Integer, Integer> inorderMap) {
        if ( preorderLeft > preorderRight ) {
            return null;
        }

        TreeNode cur = new TreeNode( preorder[preorderLeft] );
        int index = inorderMap.get( cur.val );
        int leftCount = index - inorderLeft;

        cur.left = buildTree( preorder, inorder, preorderLeft + 1, preorderLeft + leftCount, inorderLeft, index - 1, inorderMap );
        cur.right = buildTree( preorder, inorder, preorderLeft + leftCount + 1, preorderRight, index + 1, inorderRight, inorderMap );

        return cur;
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
