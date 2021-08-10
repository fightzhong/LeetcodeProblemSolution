package com.fightzhong.question_51_to_100;

import java.util.ArrayList;
import java.util.List;

public class lc_0099_RecoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode( 1 );
        root.left = new TreeNode( 3 );
        root.left.right = new TreeNode( 2 );

        new lc_0099_RecoverBinarySearchTree().recoverTree( root );
    }

    private TreeNode firstNode;
    private TreeNode secondNode;
    private TreeNode preNode;

    public void recoverTree(TreeNode root) {
        forEach( root );

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public void forEach(TreeNode root) {
        if ( root == null ) {
            return;
        }

        forEach( root.left );
        if ( preNode != null && preNode.val > root.val ) {
            if ( preNode != null && preNode.val > root.val ) {
                if ( firstNode == null ) {
                    firstNode = preNode;
                }

                secondNode = root;
            }
        }

        preNode = root;
        forEach( root.right );
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
