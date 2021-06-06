package com.fightzhong;

import java.util.HashMap;
import java.util.Map;

public class lc_0003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        new lc_0003_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("au");
    }

    public int lengthOfLongestSubstring(String s) {
        if ( s == null || s.length() == 0 ) {
            return 0;
        }

        // bbbbb
        int left = 0;
        int cur = 0;
        int maxLength = 1;
        Map<Character,Integer> cache = new HashMap<>();
        while ( cur < s.length() ) {
            char curChar = s.charAt(cur);
            Integer lastIndex = cache.get( curChar );

            // 在范围内, 是重复字符
            if ( lastIndex != null && lastIndex >= left ) {
                maxLength = Math.max( cur - left, maxLength );
                left = lastIndex + 1;
            }

            cache.put( curChar, cur++ );
        }

        return Math.max( cur - left, maxLength );
    }
}
