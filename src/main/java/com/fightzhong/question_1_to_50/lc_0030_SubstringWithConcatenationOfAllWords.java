package com.fightzhong.question_1_to_50;

import java.util.*;

public class lc_0030_SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        new lc_0030_SubstringWithConcatenationOfAllWords().findSubstring( "barfoothefoobarman",
                new String[]{"foo","bar"} );
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        CountInfo countInfo = getCountInfo(words);
        out:
        for ( int i = 0; i < s.length(); i ++ ) {
            if ( s.length() - i < countInfo.length ) {
                break;
            }

            Map<String, Integer> map = new HashMap<>(countInfo.countMap);
            int index = i;
            int totalLength = 0;
            while ( index < s.length() && totalLength < countInfo.length ) {
                String singleS = s.substring( index, index + countInfo.singleLength );
                Integer remainCount = map.get( singleS );
                if ( remainCount == null || remainCount == 0 ) {
                    continue out;
                }

                index = index + countInfo.singleLength;
                totalLength += countInfo.singleLength;
                map.put( singleS, remainCount - 1 );
            }

            result.add( index - countInfo.length );
        }

        return result;
    }

    public class CountInfo{
        private Map<String, Integer> countMap;

        private int length;

        private int singleLength;

        public CountInfo(Map<String, Integer> countMap, int length, int singleLength) {
            this.countMap = countMap;
            this.length = length;
            this.singleLength = singleLength;
        }
    }

    public CountInfo getCountInfo(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        int singleLength = 0;
        for ( String s: words ) {
            Integer v = countMap.get(s);
            v = v == null ? 1 : v + 1;
            countMap.put( s, v );
            singleLength = s.length();
        }

        return new CountInfo( countMap, singleLength * words.length, singleLength );
    }


}
