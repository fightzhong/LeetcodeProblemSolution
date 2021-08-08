package com.fightzhong.question_51_to_100;

public class lc_0096_UniqueBinarySearchTrees {
    // 动态规划解法
    public int numTrees2(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for ( int left = n; left >= 1; left -- ) {
            for ( int right = 1; right <= n; right ++ ) {
                if ( left == right ) {
                    dp[left][right] = 1;
                } else {
                    int totalCount = 0;
                    for ( int i = left; i <= right; i ++ ) {
                        int leftCount = dp[left][i - 1];
                        int rightCount = dp[i + 1][right];

                        if ( leftCount == 0 ) {
                            totalCount += rightCount;
                        } else if ( rightCount == 0 ) {
                            totalCount += leftCount;
                        } else {
                            totalCount += leftCount * rightCount;
                        }
                    }

                    dp[left][right] = totalCount;
                }
            }
        }

        return dp[1][n];
    }

    // 暴力解
    public int numTrees(int n) {
        return numTrees( 1, n );
    }

    private int numTrees(int left, int right) {
        if ( left > right ) {
            return 0;
        }

        if ( left == right ) {
            return 1;
        }

        int totalCount = 0;
        for ( int i = left; i <= right; i ++ ) {
            // 以i作为头节点, [left, i - 1]这些元素生成一颗左子树
            int leftCount = numTrees( left, i - 1 );

            // 以i作为头节点, [i + 1, right]这些元素生成一颗右子树
            int rightCount = numTrees( i + 1, right );

            if ( leftCount == 0 ) {
                totalCount += rightCount;
            } else if ( rightCount == 0 ) {
                totalCount += leftCount;
            } else {
                totalCount += leftCount * rightCount;
            }
        }

        return totalCount;
    }
}
