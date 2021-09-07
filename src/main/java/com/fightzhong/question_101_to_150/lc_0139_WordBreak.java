package com.fightzhong.question_101_to_150;

import java.util.*;

public class lc_0139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>( wordDict );
        return wordBreak( s, wordSet, new HashMap<>() );
    }

    private boolean wordBreak(String s, Set<String> wordSet, Map<String, Boolean> cache) {
        if ( s.length() == 0 ) {
            return true;
        }

        Boolean cacheResult = cache.get( s );
        if ( cacheResult != null ) {
            return cacheResult;
        }

        boolean result = false;
        for ( int tail = 1; tail <= s.length(); tail ++ ) {
            String left = s.substring( 0, tail );
            String right = s.substring( tail );
            if ( wordSet.contains( left ) && wordBreak( right, wordSet, cache ) ) {
                result = true;
                break;
            }
        }

        cache.put( s, result );

        return result;
    }
}
