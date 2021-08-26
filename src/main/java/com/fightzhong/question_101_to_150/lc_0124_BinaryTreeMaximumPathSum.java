package com.fightzhong.question_101_to_150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc_0124_BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 2 );
        root.right = new TreeNode( 3 );

        System.out.println( new lc_0124_BinaryTreeMaximumPathSum().maxPathSum( root ) );;
    }

    public int maxPathSum(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Map<TreeNode, Integer[]> cache = new HashMap<>();

        // 通过一个遍历, 得出每个节点的父节点以及该节点作为出发节点, 走左边 或者 走右边最大的值
        traverse( root, null, parentMap, cache );

        Set<TreeNode> usedSet = new HashSet<>();
        int result = Integer.MIN_VALUE;
        Set<TreeNode> keyset = parentMap.keySet();
        for ( TreeNode node: keyset ) {
            result = Math.max( result, maxPathSum( node, parentMap.get( node ), usedSet, parentMap, cache ) );
        }

        return result;
    }

    private int traverse(TreeNode cur, TreeNode parent, Map<TreeNode, TreeNode> parentMap, Map<TreeNode, Integer[]> cache) {
        if ( cur == null ) {
            return 0;
        }

        int left = traverse( cur.left, cur, parentMap, cache );
        int right = traverse( cur.right, cur, parentMap, cache );
        parentMap.put( cur, parent );

        cache.put( cur, new Integer[]{left + cur.val, right + cur.val, null} );

        return Math.max( left, right ) + cur.val;
    }

    private int maxPathSum(TreeNode cur, TreeNode pre, Set<TreeNode> usedSet, Map<TreeNode, TreeNode> parentMap, Map<TreeNode, Integer[]> cache) {
        if ( cur == null || usedSet.contains( cur ) ) {
            return 0;
        }

        usedSet.add( cur );

        int result = cur.val;
        TreeNode parent = parentMap.get( cur );
        // 走父节点的情况, 如果有缓存则取缓存
        if ( parent != null && !usedSet.contains( parent ) ) {
            if ( cache.get( cur )[2] == null ) {
                cache.get( cur )[2] = maxPathSum( parent, cur, usedSet, parentMap, cache );
            }
            result = Math.max( result, cache.get( cur )[2] + result );
        }

        // 走左节点或者走右节点的情况, 直接取缓存
        if ( pre == cur.left ) {
            result = Math.max( result, cache.get( cur )[1] );
        } else if ( pre == cur.right ) {
            result = Math.max( result, cache.get( cur )[0] );
        } else {
            result = Math.max( result, cache.get( cur )[0] );
            result = Math.max( result, cache.get( cur )[1] );
        }

        usedSet.remove( cur );

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
