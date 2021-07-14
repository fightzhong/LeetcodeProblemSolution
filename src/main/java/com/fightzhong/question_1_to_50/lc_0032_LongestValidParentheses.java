package com.fightzhong.question_1_to_50;

public class lc_0032_LongestValidParentheses {
    public static void main(String[] args) {
        new lc_0032_LongestValidParentheses().longestValidParentheses_1( "()(())" );
    }

    public int longestValidParentheses_2(String s) {
        if ( s.length() == 1 ) {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 0;
        dp[1] = s.charAt( 1 ) == ')' && s.charAt( 0 ) == '(' ? 2 : 0;

        int max = 0;
        for ( int i = 2; i < s.length(); i ++ ) {
            if ( s.charAt( i ) == '(' ) {
                dp[i] = 0;
            } else {
                if ( s.charAt( i - 1 ) == '(' ) {
                    dp[i] = dp[i-2] + 2;
                } else {
                    if ( i - dp[i-1] - 1 >= 0 && s.charAt( i - dp[i-1] - 1 ) == '(' ) {
                        dp[i] = dp[i-1] + 2;
                        if ( i - dp[i-1] - 2 >= 0 ) {
                            dp[i] = dp[i] + dp[i - dp[i-1] - 2];
                        }
                    }
                }
            }

            max = Math.max( max, dp[i] );
        }

        return max;
    }

    public int longestValidParentheses_1(String s) {
        int result = 0;
        for ( int i = 0; i < s.length(); i ++ ) {
            if ( s.charAt( i ) == ')' ) {
                continue;
            }

            int startBrackets = 0;
            int endBrackets = 0;
            int sIndex = i;
            int count = 0;
            while ( sIndex < s.length() ) {
                char curChar = s.charAt( sIndex );
                if ( curChar == '(' ) {
                    startBrackets ++;
                } else if ( curChar == ')' ) {
                    endBrackets ++;
                    if ( startBrackets < endBrackets ) {
                        break;
                    } else if ( startBrackets == endBrackets ) {
                        count += startBrackets + endBrackets;
                        startBrackets = 0;
                        endBrackets = 0;
                    }
                }

                sIndex ++;
            }

            result = Math.max( result, count );
            i = count == 0 ? i : i + count - 1;
        }

        return result;
    }
}
