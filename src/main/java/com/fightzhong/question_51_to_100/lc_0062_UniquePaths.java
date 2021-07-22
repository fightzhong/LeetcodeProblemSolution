package com.fightzhong.question_51_to_100;

public class lc_0062_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for ( int x = m - 1; x >= 0; x -- ) {
            for ( int y = n - 1; y >= 0; y -- ) {
                if ( x == m - 1 && y == n - 1 ) {
                    dp[x][y] = 1;
                } else {
                    dp[x][y] = dp[x + 1][y] + dp[x][y + 1];
                }
            }
        }

        return dp[0][0];
    }
}
