package com.fightzhong.question_101_to_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc_0103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<TreeNode> curLevelNodeList = new ArrayList<>();
        if ( root != null ) {
            curLevelNodeList.add( root );
        }
        return zigzagLevelOrder( curLevelNodeList, false );
    }

    private LinkedList<List<Integer>> zigzagLevelOrder(List<TreeNode> curLevelNodeList, boolean leftToRight) {
        if ( curLevelNodeList == null || curLevelNodeList.size() == 0 ) {
            return new LinkedList<>();
        }

        List<TreeNode> nextLevel = new ArrayList<>();
        List<Integer> curLevelData = new ArrayList<>();

        int index = 0;
        while ( index < curLevelNodeList.size() ) {
            TreeNode left = curLevelNodeList.get( index );
            TreeNode right = curLevelNodeList.get( curLevelNodeList.size() - index - 1 );

            curLevelData.add( left.val );

            if ( leftToRight ) {
                if ( right.left != null ) {
                    nextLevel.add( right.left );
                }

                if ( right.right != null ) {
                    nextLevel.add( right.right );
                }
            } else {
                if ( right.right != null ) {
                    nextLevel.add( right.right );
                }

                if ( right.left != null ) {
                    nextLevel.add( right.left );
                }
            }

            index ++;
        }

        LinkedList<List<Integer>> result = zigzagLevelOrder( nextLevel, !leftToRight );
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
