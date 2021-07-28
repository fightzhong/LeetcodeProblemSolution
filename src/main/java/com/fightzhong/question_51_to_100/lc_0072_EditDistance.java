package com.fightzhong.question_51_to_100;

import java.util.Arrays;
import java.util.Random;

public class lc_0072_EditDistance {
    public int minDistanceDp(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for ( int i = 0; i <= word2.length() - 1; i ++ ) {
            dp[word1.length()][i] = word2.length() - i;
        }

        for ( int i = 0; i <= word1.length() - 1; i ++ ) {
            dp[i][word2.length()] = word1.length() - i;
        }

        for ( int i = word1.length() - 1; i >= 0; i -- ) {
            for (int j = word2.length() - 1; j >= 0; j --) {
                char c1 = word1.charAt( i );
                char c2 = word2.charAt( j );

                if ( c1 == c2 ) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i + 1][j + 1], dp[i + 1][j]), dp[i][j + 1] ) + 1;
                }
            }
        }

        return dp[0][0];
    }

    public int minDistance(String word1, String word2) {
        return minDistance( word1, word2, 0, 0 );
    }

    private int minDistance(String word1, String word2, int index1, int index2) {
        if ( index1 == word1.length() && index2 == word2.length() ) {
            return 0;
        } else if ( index1 == word1.length() ) {
            return word2.length() - index2;
        } else if ( index2 == word2.length() ) {
            return word1.length() - index1;
        }

        char c1 = word1.charAt( index1 );
        char c2 = word2.charAt( index2 );
        if ( c1 == c2 ) {
            return minDistance( word1, word2, index1 + 1, index2 + 1 );
        } else {
            //  替换
            int r1 = minDistance( word1, word2, index1 + 1, index2 + 1 );

            // 删除
            int r2 = minDistance( word1, word2, index1 + 1, index2 );

            // 新增
            int r3 = minDistance( word1, word2, index1, index2 + 1 );

            return Math.min( Math.min(r1, r2), r3 ) + 1;
        }
    }
}
