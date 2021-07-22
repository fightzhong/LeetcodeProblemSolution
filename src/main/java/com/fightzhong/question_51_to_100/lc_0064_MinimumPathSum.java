package com.fightzhong.question_51_to_100;

public class lc_0064_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int xLength = grid.length;
        int yLength = grid[0].length;

        int[][] dp = new int[xLength][yLength];
        for ( int x = xLength - 1; x >= 0; x -- ) {
            for ( int y = yLength - 1; y >= 0; y -- ) {
                int minValue;
                if ( y + 1 >= yLength && x + 1 >= xLength ) {
                    minValue = 0;
                } else if ( y + 1 >= yLength ) {
                    minValue = dp[x + 1][y];
                } else if ( x + 1 >= xLength ) {
                    minValue = dp[x][y + 1];
                } else {
                    minValue = Math.min( dp[x + 1][y], dp[x][y + 1] );
                }

                dp[x][y] = grid[x][y] + minValue;
            }
        }

        return dp[0][0];
    }
}
