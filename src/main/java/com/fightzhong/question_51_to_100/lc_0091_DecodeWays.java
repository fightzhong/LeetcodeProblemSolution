package com.fightzhong.question_51_to_100;

public class lc_0091_DecodeWays {
    public static void main(String[] args) {
        System.out.println( (int)'1' );
        System.out.println( (int)'6' );
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 2];
        dp[s.length()] = 1;
        dp[s.length() + 1] = 1;

        for ( int i = s.length() - 1; i >= 0; i -- ) {
            int v = s.charAt( i );
            if ( v == '0' ) {
                dp[i] = 0;
            } else {
                int count1 = dp[i + 1];
                int count2 = 0;

                if ( i + 1 < s.length() && ( v == 49 || (v == 50 && s.charAt( i + 1 ) <= 54) ) ) {
                    count2 = dp[i + 2];
                }

                dp[i] = count1 + count2;
            }
        }

        return dp[0];
    }
}
