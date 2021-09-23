package com.fightzhong.question_101_to_150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc_0128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for ( int i: nums ) {
            numSet.add( i );
        }

        Map<Integer, Integer> numToCount = new HashMap<>();
        int max = 0;
        for ( int i: nums ) {
            if ( numToCount.containsKey( i ) ) {
                continue;
            }

            int v = i;
            int count = 0;
            while ( numSet.contains( v ) ) {
                Integer cacheCount = numToCount.get( v );
                if ( cacheCount == null ) {
                    count ++;
                    numToCount.put( v, 1 );
                } else {
                    count += cacheCount;
                    break;
                }

                numToCount.put( v, 1 );
                v ++;
            }

            max = Math.max( max, count );
            numToCount.put( i, count );
        }

        return max;
    }
}
