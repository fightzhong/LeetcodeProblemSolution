package com.fightzhong.question_51_to_100;

public class lc_0063_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        for ( int x = obstacleGrid.length - 1; x >= 0; x -- ) {
            for ( int y = obstacleGrid[0].length - 1; y >= 0; y -- ) {
                if ( obstacleGrid[x][y] == 1 ) {
                    dp[x][y] = 0;
                } else if ( x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1 ) {
                    dp[x][y] = 1;
                } else {
                    dp[x][y] = dp[x + 1][y] + dp[x][y + 1];
                }
            }
        }

        return dp[0][0];
    }
}
