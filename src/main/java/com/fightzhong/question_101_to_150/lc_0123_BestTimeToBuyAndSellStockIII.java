package com.fightzhong.question_101_to_150;

public class lc_0123_BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][4][2];
        for ( int i = dp.length - 1; i >= 0; i -- ) {
            for ( int j = 0; j < dp[i].length; j ++ ) {
                for ( int k = 0; k < dp[i][j].length; k ++ ) {
                    int maxProfit;
                    if ( k == 0 ) {
                        int profit1 = -prices[i] + ( i + 1 >= dp.length || j - 1 < 0 ? 0 : dp[i + 1][j - 1][1] );
                        int profit2 = i + 1 >= dp.length ? 0 : dp[i + 1][j][0];
                        maxProfit = Math.max( profit1, profit2 );
                    } else {
                        int profit1 = prices[i] + ( i + 1 >= dp.length || j - 1 < 0 ? 0 : dp[i + 1][j - 1][0] );
                        int profit2 = i + 1 >= dp.length ? 0 : dp[i + 1][j][1];
                        maxProfit = Math.max( profit1, profit2 );
                    }

                    dp[i][j][k] = maxProfit;
                }
            }
        }

        return dp[0][3][0];
    }

    private int maxProfit(int[] prices, int index, int operateCount, boolean selled) {
        if ( operateCount < 0 || index >= prices.length ) {
            return 0;
        }

        // 如果股票是卖出的状态, 那么只能够操作买入或者不处理
        if ( selled ) {
            // 买入
            int profit1 = -prices[index] + maxProfit( prices, index + 1, operateCount - 1, false );

            // 不处理
            int profit2 = maxProfit( prices, index + 1, operateCount, true );

            return Math.max( profit1, profit2 );
        } else {
            // 如果股票时买入的状态, 那么只能操作卖出或者不处理

            // 卖出
            int profit1 = prices[index] + maxProfit( prices, index + 1, operateCount - 1, true );

            // 不处理
            int profit2 = maxProfit( prices, index + 1, operateCount, false );

            return Math.max( profit1, profit2 );
        }
    }
}
