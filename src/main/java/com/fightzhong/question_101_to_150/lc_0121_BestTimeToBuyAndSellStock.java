package com.fightzhong.question_101_to_150;

public class lc_0121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for ( int i = dp.length - 1; i >= 0; i -- ) {
            for ( int j = 0; j < dp[i].length; j ++ ) {
                if ( j == 0 ) {
                    dp[i][j] = Math.max( prices[i], i + 1 >= dp.length ? 0 : dp[i + 1][0] );
                } else {
                    dp[i][j] = Math.max( -prices[i] + ( i + 1 >= dp.length ? 0 : dp[i + 1][0] ), i + 1 >= dp.length ? 0 : dp[i + 1][1] );
                }
            }
        }

        return Math.max( dp[0][1], 0 );
    }

    private int maxProfit(int[] prices, int index, boolean buy) {
        if ( index == prices.length ) {
            return 0;
        }

        if ( buy ) {
            return Math.max( prices[index], maxProfit( prices, index + 1, true) );
        } else {
            return Math.max( -prices[index] + maxProfit( prices, index + 1, true ), maxProfit( prices, index + 1, false ) );
        }
    }
}
