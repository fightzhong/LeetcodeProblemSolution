package com.fightzhong.question_51_to_100;

import java.util.ArrayList;
import java.util.List;

public class lc_0095_UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees( 1, n );
    }

    private List<TreeNode> generateTrees(int left, int right) {
        if ( left > right ) {
            return null;
        }

        List<TreeNode> result = new ArrayList<>();
        if ( left == right ) {
            result.add( new TreeNode( left ) );
            return result;
        }

        for ( int i = left; i <= right; i ++ ) {
            // 以i作为头节点, [left, i - 1]这些元素生成一颗左子树
            List<TreeNode> leftTreeList = generateTrees( left, i - 1 );

            // 以i作为头节点, [i + 1, right]这些元素生成一颗右子树
            List<TreeNode> rightTreeList = generateTrees( i + 1, right );

            result.addAll( mergeTree( leftTreeList, rightTreeList, i ) );
        }

        return result;
    }

    private List<TreeNode> mergeTree(List<TreeNode> leftTreeList, List<TreeNode> rightTreeList, int val) {
        List<TreeNode> result = new ArrayList<>();
        if ( leftTreeList == null ) {
            for (TreeNode rightNode: rightTreeList) {
                TreeNode cur = new TreeNode( val );
                cur.right = rightNode;

                result.add( cur );
            }
        } else if ( rightTreeList == null ) {
            for (TreeNode leftNode: leftTreeList) {
                TreeNode cur = new TreeNode( val );
                cur.left = leftNode;

                result.add( cur );
            }
        } else {
            // 合并子树
            for ( TreeNode leftTree: leftTreeList ) {
                for (TreeNode rightNode: rightTreeList) {
                    TreeNode cur = new TreeNode( val );
                    cur.left = leftTree;
                    cur.right = rightNode;

                    result.add( cur );
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
