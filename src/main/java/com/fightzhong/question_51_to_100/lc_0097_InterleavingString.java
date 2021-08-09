package com.fightzhong.question_51_to_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc_0097_InterleavingString {
    public static void main(String[] args) {
        System.out.println( new lc_0097_InterleavingString().isInterleave( "a", "", "a" ) );;
    }

    private final Map<String, Boolean> cache = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        if ( s1.length() + s2.length() != s3.length() ) {
            return false;
        }

        return isInterleave( s1, s2, s3, 0, 0, 0 );
    }

    private boolean isInterleave(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index) {
        String key = s1Index + "_" + s2Index + "_" + s3Index;
        Boolean result = cache.get( key );
        if ( result != null ) {
            return result;
        } else if ( s1Index == s1.length() && s2Index == s2.length() ) {
            result = true;
        }else if ( s1Index == s1.length() ) {
            char c2 = s2.charAt( s2Index );
            char c3 = s3.charAt( s3Index );

            result = c2 == c3 && isInterleave(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1);
        } else if ( s2Index == s2.length() ) {
            char c1 = s1.charAt( s1Index );
            char c3 = s3.charAt( s3Index );
            result = c1 == c3 && isInterleave(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1);
        } else {
            char c1 = s1.charAt( s1Index );
            char c2 = s2.charAt( s2Index );
            char c3 = s3.charAt( s3Index );
            if ( c1 != c3 && c2 != c3 ) {
                result = false;
            } else if ( c1 == c3 && c2 == c3 ) {
                result = isInterleave( s1, s2, s3, s1Index + 1, s2Index, s3Index + 1 ) ||
                        isInterleave( s1, s2, s3, s1Index, s2Index + 1, s3Index + 1 );
            } else if ( c1 == c3 ) {
                result = isInterleave( s1, s2, s3, s1Index + 1, s2Index, s3Index + 1 );
            } else {
                result = isInterleave( s1, s2, s3, s1Index, s2Index + 1, s3Index + 1 );
            }
        }

        cache.put( key, result );

        return result;
    }
}
