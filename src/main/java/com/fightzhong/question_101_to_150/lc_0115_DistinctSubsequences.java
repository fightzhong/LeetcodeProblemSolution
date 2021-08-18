package com.fightzhong.question_101_to_150;

import java.util.Arrays;

public class lc_0115_DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if ( s.length() < t.length() ){
            return 0;
        }

        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[t.length()], 1);

        for ( int tIndex = t.length() - 1; tIndex >= 0; tIndex -- ) {
            for ( int sIndex = s.length() - 1; sIndex >= 0; sIndex -- ) {
                char tChar = t.charAt( tIndex );
                char sChar = s.charAt( sIndex );

                if ( sChar == tChar ) {
                    dp[tIndex][sIndex] = dp[tIndex + 1][sIndex + 1] + dp[tIndex][sIndex + 1];
                } else {
                    dp[tIndex][sIndex] = dp[tIndex][sIndex + 1];
                }
            }
        }

        return dp[0][0];
    }
}
