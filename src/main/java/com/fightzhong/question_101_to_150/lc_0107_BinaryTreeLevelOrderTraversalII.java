package com.fightzhong.question_101_to_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc_0107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return levelOrderBottom( root == null ? new ArrayList<>() : Collections.singletonList(root));
    }

    private List<List<Integer>> levelOrderBottom(List<TreeNode> preLevelNode) {
        if ( preLevelNode.size() == 0 ) {
            return new ArrayList<>();
        }

        List<Integer> curLevelVal = new ArrayList<>();
        List<TreeNode> nextLevelNode = new ArrayList<>();
        for ( TreeNode node: preLevelNode ) {
            curLevelVal.add( node.val );
            if ( node.left != null ) {
                nextLevelNode.add( node.left );
            }

            if ( node.right != null ) {
                nextLevelNode.add( node.right );
            }
        }

        List<List<Integer>> result = levelOrderBottom( nextLevelNode );
        result.add( curLevelVal );

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
