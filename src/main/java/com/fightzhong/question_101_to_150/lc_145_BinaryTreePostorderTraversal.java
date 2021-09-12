package com.fightzhong.question_101_to_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc_145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<StackInfo> stack = new LinkedList<>();
        if ( root != null ) {
            stack.addLast( new StackInfo( root, false ) );
            while ( stack.size() != 0 ) {
                StackInfo stackInfo = stack.getLast();
                if ( stackInfo.print ) {
                    stack.removeLast();
                    result.add( stackInfo.node.val );
                } else {
                    stackInfo.print = true;

                    if ( stackInfo.node.right != null ) {
                        stack.addLast( new StackInfo( stackInfo.node.right, false ) );
                    }

                    if ( stackInfo.node.left != null ) {
                        stack.addLast( new StackInfo( stackInfo.node.left, false ) );
                    }
                }
            }
        }

        return result;
    }

    private static class StackInfo {
        public boolean print;
        public TreeNode node;

        public StackInfo (TreeNode node, boolean print) {
            this.node = node;
            this.print = print;
        }
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
