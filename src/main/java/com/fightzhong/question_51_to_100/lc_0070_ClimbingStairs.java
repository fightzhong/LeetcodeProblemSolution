package com.fightzhong.question_51_to_100;

public class lc_0070_ClimbingStairs {
    public int climbStairs(int n) {
        if ( n == 1 ) {
            return 1;
        } else if ( n == 2 ) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = 1;
        dp[n - 2] = 2;

        for ( int i = n - 3; i >= 0; i -- ) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0];
    }
}
