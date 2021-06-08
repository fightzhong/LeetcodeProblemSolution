package com.fightzhong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc_0010_RegularExpressionMatching {
    public static void main(String[] args) {
        new lc_0010_RegularExpressionMatching().isMatch( "aa", "a*" );
    }

    public boolean isMatch(String s, String p) {

        Map<String, Boolean> cache = new HashMap<>();
        String[] sArr = s.equals( "" ) ? new String[0] : s.split("");
        String[] pArr = p.equals( "" ) ? new String[0] :getPArr( p );

        return isMatch( sArr, pArr, 0, 0, cache );
    }

    private boolean isMatch (String[] sArr, String[] pArr, int sIndex, int pIndex, Map<String, Boolean> cache) {
        if ( sIndex == sArr.length && pIndex == pArr.length ) {
            return true;
        } else if ( pIndex == pArr.length ) {
            return false;
        } else if ( sIndex == sArr.length ){
            for ( int i = pIndex; i < pArr.length; i ++ ) {
                if ( pArr[i].length() != 2 ) {
                    return false;
                }
            }

            return true;
        }

        String key = String.format( "%s_%s", sIndex, pIndex );
        if ( cache.containsKey( key ) ) {
            return cache.get( key );
        }

        String curS = sArr[sIndex];
        String curP = pArr[pIndex];
        boolean result;
        if ( curP.equals( ".*" ) || curP.equals( curS + "*" ) ) {
            result = isMatch( sArr, pArr, sIndex + 1, pIndex + 1, cache ) ||
                    isMatch( sArr, pArr, sIndex, pIndex + 1, cache ) ||
                    isMatch( sArr, pArr, sIndex + 1, pIndex, cache );
        } else if ( curP.length() == 2 && !curP.equals( curS + "*" ) ) {
            result = isMatch( sArr, pArr, sIndex, pIndex + 1, cache );
        } else if ( curS.equals( curP ) || curP.equals( "." ) ){
            result = isMatch( sArr, pArr, sIndex + 1, pIndex + 1, cache );
        } else {
            result = false;
        }

        cache.put( key, result );
        return result;
    }

    private String[] getPArr (String p) {
        int pArrLength = p.length();
        for ( int i = 0; i < p.length(); i ++ ) {
            if ( p.charAt( i ) == '*' ) {
                pArrLength --;
            }
        }

        String[] pArr = new String[pArrLength];
        int pArrIndex = 0;
        for ( int i = 0; i < p.length(); i ++ ) {
            pArr[pArrIndex] = String.valueOf( p.charAt( i ) );
            if ( i + 1 < p.length() && p.charAt( i + 1 ) == '*' ) {
                pArr[pArrIndex] += "*";
                i ++;
            }
            pArrIndex ++;
        }

        return pArr;
    }
}
