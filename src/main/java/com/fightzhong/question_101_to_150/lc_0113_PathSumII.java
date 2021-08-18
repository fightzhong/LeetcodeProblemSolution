package com.fightzhong.question_101_to_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc_0113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null ) {
            return result;
        } else if ( root.left == null && root.right == null ) {
            if ( targetSum == root.val ) {
                LinkedList<Integer> item = new LinkedList<>();
                item.addFirst( targetSum );

                result.add( item );
            }
            return result;
        } else if ( root.left == null ) {
            List<List<Integer>> curResult = pathSum( root.right, targetSum - root.val );
            for ( List<Integer> item: curResult ) {
                ((LinkedList<Integer>)item).addFirst( root.val );
            }

            return curResult;
        } else if ( root.right == null ) {
            List<List<Integer>> curResult = pathSum( root.left, targetSum - root.val );
            for ( List<Integer> item: curResult ) {
                ((LinkedList<Integer>)item).addFirst( root.val );
            }

            return curResult;
        }

        List<List<Integer>> rightResult = pathSum( root.right, targetSum - root.val );
        for ( List<Integer> item: rightResult ) {
            ((LinkedList<Integer>)item).addFirst( root.val );
            result.add( item );
        }

        List<List<Integer>> leftResult = pathSum( root.left, targetSum - root.val );
        for ( List<Integer> item: leftResult ) {
            ((LinkedList<Integer>)item).addFirst( root.val );
            result.add( item );
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
