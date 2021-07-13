package com.fightzhong;

import java.util.*;

public class lc_0049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for ( String str: strs ) {
            char[] chars = str.toCharArray();
            Arrays.sort( chars );
            String sortStr = String.valueOf( chars );

            List<String> data = map.get( sortStr );
            if ( data == null ) {
                data = new ArrayList<>();
                map.put( sortStr, data );
            }

            data.add( str );
        }

        return new ArrayList<>(map.values());
    }
}
