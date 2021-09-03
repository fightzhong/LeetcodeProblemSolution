package com.fightzhong.question_101_to_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc_0131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if ( s.length() == 0 ) {
            result.add( new LinkedList<>() );
            return result;
        }

        for ( int i = 1; i <= s.length(); i ++ ) {
            String left = s.substring( 0, i );
            String right = s.substring( left.length(), s.length() );
            if ( isPlalindromeStr( left ) ) {
                List<List<String>> next = partition( right );
                for ( List<String> item: next ) {
                    ((LinkedList<String>)item).addFirst( left );
                }

                result.addAll( next );
            }
        }

        return result;
    }

    private boolean isPlalindromeStr(String s) {
        int l = 0;
        int r = s.length() - 1;
        while ( l < r ) {
            if ( s.charAt( l ) != s.charAt( r ) ) {
                return false;
            }

            l ++;
            r --;
        }

        return true;
    }
}
