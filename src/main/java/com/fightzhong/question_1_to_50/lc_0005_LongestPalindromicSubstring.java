package com.fightzhong.question_1_to_50;


public class lc_0005_LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new lc_0005_LongestPalindromicSubstring().longestPalindrome_2("babadada"));
    }

    public String longestPalindrome_2(String s) {
        if ( s == null || s.length() == 0 ) {
            return null;
        } else if ( s.length() == 1 ) {
            return s;
        }

        String newS = populateStr( s );
        int resultLeft = 0;
        int resultRight = 0;
        int center = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int[] cache = new int[newS.length()];
        for ( int i = 0; i < newS.length(); i ++ ) {
            cache[i] = 1;
            if ( i >= maxRight ) {
                int curLeft = i;
                int curRight = i;
                center = i;
                while ( --curLeft >= 0 && ++curRight < newS.length() && newS.charAt(curLeft) == newS.charAt(curRight) ) {
                    maxLeft = curLeft;
                    maxRight = curRight;
                    cache[i] = maxRight - maxLeft + 1;
                }
            } else {
                if ( 2 * center - i - cache[2 * center - i] / 2 > maxLeft ) {
                    cache[i] = cache[2 * center - i];
                } else {
                    center = i;
                    int curRight = maxRight;
                    int curLeft = 2 * i - maxRight;
                    maxLeft = curLeft;
                    cache[i] = maxRight - maxLeft + 1;

                    while ( --curLeft >= 0 && ++curRight < newS.length() && newS.charAt(curLeft) == newS.charAt(curRight) ) {
                        maxLeft = curLeft;
                        maxRight = curRight;
                        cache[i] = maxRight - maxLeft + 1;
                    }
                }
            }

            if ( maxRight - maxLeft > resultRight - resultLeft ) {
                resultRight = maxRight;
                resultLeft = maxLeft;
            }
        }

        String result = newS.substring( resultLeft, resultRight + 1 );
        return result.length() == 1 ? String.valueOf(s.charAt(0)) : result.replace( "#", "" );
    }

    /**
     * 暴力解
     */
    public String longestPalindrome_1(String s) {
        if ( s == null || s.length() == 0 ) {
            return null;
        } else if ( s.length() == 1 ) {
            return s;
        }

        String newS = populateStr( s );
        int maxLeft = 0;
        int maxRight = 0;
        for ( int i = 0; i < newS.length(); i ++ ) {
            int left = i;
            int right = i;

            while ( --left > 0 && ++right < newS.length() && newS.charAt(left) == newS.charAt(right) ) {
                if ( right - left + 1 > maxRight - maxLeft + 1 ) {
                    maxLeft = left;
                    maxRight = right;
                }
            }
        }

        String result = newS.substring( maxLeft, maxRight + 1 );
        return result.length() == 1 ? String.valueOf(s.charAt(0)) : result.replace( "#", "" );
    }

    private String populateStr (String str) {
        StringBuilder builder = new StringBuilder();
        builder.append( "#" );

        for ( int i = 0; i < str.length(); i ++ ) {
            builder.append( str.charAt( i ) ).append( "#" );
        }

        return builder.toString();
    }
}
