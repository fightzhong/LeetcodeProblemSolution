package com.fightzhong.question_101_to_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc_0102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> curLevelNodeList = new ArrayList<>();
        if ( root != null ) {
            curLevelNodeList.add( root );
        }
        return levelOrder( curLevelNodeList );
    }

    private LinkedList<List<Integer>> levelOrder(List<TreeNode> curLevelNodeList) {
        if ( curLevelNodeList == null || curLevelNodeList.size() == 0 ) {
            return new LinkedList<>();
        }

        List<TreeNode> nextLevel = new ArrayList<>();
        List<Integer> curLevelData = new ArrayList<>();
        for ( TreeNode node: curLevelNodeList ) {
            if ( node.left != null ) {
                nextLevel.add( node.left );
            }

            if ( node.right != null ) {
                nextLevel.add( node.right );
            }

            curLevelData.add( node.val );
        }

        LinkedList<List<Integer>> result = levelOrder( nextLevel );
        result.addFirst( curLevelData );

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
