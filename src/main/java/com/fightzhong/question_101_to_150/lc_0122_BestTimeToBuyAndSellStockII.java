package com.fightzhong.question_101_to_150;

public class lc_0122_BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for ( int i = dp.length - 1; i >= 0; i -- ) {
            for ( int j = dp[i].length - 1; j >= 0; j -- ) {
                int profit1 = ( j == 0 ? -prices[i] : prices[i] ) + ( i + 1 >= dp.length ? 0 : dp[i + 1][j == 0 ? 1 : 0] );
                int profit2 = ( i + 1 >= dp.length ? 0 : dp[i + 1][j] );
                dp[i][j] = Math.max( profit1, profit2 );
            }
        }

        return dp[0][0];
    }

    private int maxProfit(int[] prices, int index, boolean selled) {
        if ( index >= prices.length ) {
            return 0;
        }

        int profit1 = ( selled ? -prices[index] : prices[index] ) + maxProfit( prices, index + 1, !selled );
        int profit2 = maxProfit( prices, index + 1, selled );
        return Math.max( profit1, profit2 );
    }
}
