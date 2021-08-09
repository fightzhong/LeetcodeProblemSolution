package com.fightzhong.question_51_to_100;

public class lc_0098_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if ( root == null ) {
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        if ( left != null ) {
            if ( ( left.val >= root.val ) || ( left.right != null && left.right.val >= root.val ) ) {
                return false;
            }
        }

        if ( right != null ) {
            if ( ( right.val <= root.val ) || ( right.left != null && right.left.val <= root.val ) ) {
                return false;
            }
        }

        return isValidBST( root.left ) && isValidBST( root.right );
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
