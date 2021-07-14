package com.fightzhong.question_1_to_50;

public class lc_0014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        out:
        while ( true ) {
            char c = '#';
            for ( String s: strs ) {
                if ( index >= s.length() ) {
                    break out;
                }

                char cur = s.charAt( index );
                if ( c == '#' ) {
                    c = cur;
                } else if ( c != cur ) {
                    break out;
                }
            }

            result.append(c);
            index ++;
        }

        return result.toString();
    }
}
