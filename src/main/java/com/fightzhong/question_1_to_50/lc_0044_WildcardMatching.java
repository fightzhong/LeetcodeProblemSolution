package com.fightzhong.question_1_to_50;

import java.util.HashMap;
import java.util.Map;

public class lc_0044_WildcardMatching {
    public static void main(String[] args) {
        System.out.println( new lc_0044_WildcardMatching().isMatch2(
                "cb",
                "*?a" ) );
    }

    public boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for ( int i = 0; i < s.length() - 1; i ++ ) {
            dp[i][p.length()] = false;
        }

        boolean result = true;
        for ( int i = 0; i < p.length() - 1; i ++ ) {
            if ( p.charAt( i ) != '*' ) {
                result = false;
            }
            dp[s.length()][i] = result;
        }

        for ( int i = s.length() - 1; i >= 0; i -- ) {
            for ( int j = p.length() - 1; j >= 0; j -- ) {
                char sChar = s.charAt(i);
                char pChar = p.charAt(j);
                if ( sChar == pChar || pChar == '?' ) {
                    result = dp[i + 1][j + 1];
                } else if ( pChar == '*' ) {
                    result = dp[i + 1][j] || dp[i + 1][j + 1] || dp[i][j + 1];
                } else {
                    result = false;
                }

                dp[i][j] = result;
            }
        }

        return dp[0][0];
    }

    public boolean isMatch(String s, String p) {
        Map<String, Boolean> cache = new HashMap<>();
        return isMatch( s, p, 0, 0, cache );
    }

    private String generateKey(int sIndex, int pIndex) {
        return sIndex + "_" + pIndex;
    }

    private boolean isMatch(String s, String p, int sIndex,
                            int pIndex, Map<String, Boolean> cache) {
        String key = generateKey( sIndex, pIndex );
        if ( cache.containsKey( key ) ) {
            return cache.get( key );
        }

        boolean result;
        if ( sIndex == s.length() && pIndex == p.length() ) {
            result = true;
        } else if ( pIndex == p.length() ) {
            result = false;
        } else if ( sIndex == s.length() ) {
            result = true;
            for ( int i = pIndex; i < p.length(); i ++ ) {
                if ( p.charAt(i) != '*' ) {
                    result = false;
                    break;
                }
            }
        } else {
            char sChar = s.charAt(sIndex);
            char pChar = p.charAt(pIndex);
            if ( sChar == pChar || pChar == '?' ) {
                result = isMatch( s, p, sIndex + 1, pIndex + 1, cache );
            } else if ( pChar == '*' ) {
                result = isMatch( s, p, sIndex + 1, pIndex, cache ) ||
                        isMatch( s, p, sIndex + 1, pIndex + 1, cache ) ||
                        isMatch( s, p, sIndex, pIndex + 1, cache );
            } else {
                result = false;
            }
        }

        cache.put( key, result );
        return result;
    }
}
