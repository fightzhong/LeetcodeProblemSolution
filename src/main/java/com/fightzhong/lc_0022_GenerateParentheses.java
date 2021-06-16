package com.fightzhong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc_0022_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println( generateParenthesisInDp( 3 ) );
    }

    public List<String> generateParenthesis(int n) {
        Map<String, List<String>> cache = new HashMap<>();
        return generateParenthesis( 1, n * 2, 0, cache );
    }

    private List<String> generateParenthesis(int curCount, int targetCount,
                                             int openCount, Map<String, List<String>> cache) {
        String cacheKey = String.format( "%s_%s", curCount, openCount );
        if ( cache.containsKey( cacheKey ) ) {
            return cache.get( cacheKey );
        }

        List<String> result = new ArrayList<>();
        if ( curCount == targetCount ) {
            if ( openCount == 1 ) {
                result.add( ")" );
            }
        } else  if ( openCount == 0 ) {
            List<String> data = generateParenthesis( curCount + 1, targetCount, openCount + 1, cache );
            for ( String s: data ) {
                result.add( "(" + s );
            }

        } else {
            List<String> data = generateParenthesis( curCount + 1, targetCount, openCount + 1, cache );
            for ( String s: data ) {
                result.add( "(" + s );
            }

            data = generateParenthesis( curCount + 1, targetCount, openCount - 1, cache );
            for ( String s: data ) {
                result.add( ")" + s );
            }
        }

        cache.put( cacheKey, result );
        return result;
    }

    public static List generateParenthesisInDp(int n) {
        int targetCount = n * 2;
        List[][] dp = new ArrayList[n * 2 + 1][n + 1];
        List[] end = dp[targetCount];
        for ( int i = 0; i < end.length; i ++ ) {
            end[i] = new ArrayList();
            if ( i == 1 ) {
                end[i].add( ")" );
            }
        }

        for ( int i = dp.length - 2; i > 0; i -- ) {
            for ( int j = 0; j < dp[i].length; j ++ ) {
                List result = new ArrayList();
                if ( j == 0 ) {
                    List data = dp[i + 1][j + 1];
                    for ( Object s: data ) {
                        result.add( "(" + s );
                    }
                } else {
                    if ( j + 1 < dp[i].length ) {
                        List data = dp[i + 1][j + 1];
                        for ( Object s: data ) {
                            result.add( "(" + s );
                        }
                    }

                    List data = dp[i + 1][j - 1];
                    for ( Object s: data ) {
                        result.add( ")" + s );
                    }
                }

                dp[i][j] = result;
            }
        }

        return dp[1][0];
    }
}
