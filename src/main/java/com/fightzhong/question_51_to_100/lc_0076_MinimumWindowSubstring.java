package com.fightzhong.question_51_to_100;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class lc_0076_MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println( new lc_0076_MinimumWindowSubstring().minWindow( "ADOBECODEBANCAB", "ABC" ) );
    }

    public String minWindow(String s, String t) {
        if ( t.length() == 0 ) {
            return "";
        }

        HashMap<Character, Integer> charToCount = new HashMap<>();
        for ( int i = 0; i < t.length(); i ++ ) {
            char c = t.charAt(i);
            Integer v = charToCount.get(c);
            if ( v == null ) {
                v = 0;
            }
            charToCount.put( c, v + 1 );
        }

        String minWindow = s;
        boolean find = false;
        int totalTCount = t.length();
        Integer startIndex = null;
        for ( int i = 0; i < s.length(); i ++ ) {
            char c = s.charAt(i);
            Integer count = charToCount.get( c );
            if ( count == null ) {
                continue;
            } else if ( count <= 0 ) {
                charToCount.put( c, count - 1 );
            } else {
                startIndex = startIndex == null ? i : startIndex;
                totalTCount --;
                charToCount.put( c, count - 1 );

                // totalCount为0, 则说明找到一组包含所有t字符串中字符的窗口了
                if ( totalTCount == 0 ) {
                    while ( startIndex <= i ) {
                        char sChar = s.charAt( startIndex );
                        Integer sCount = charToCount.get( sChar );
                        if ( sCount == null ) {
                            startIndex ++;
                            continue;
                        }

                        if ( totalTCount > 0 ) { // 第二步
                            break;
                        } else if ( sCount <= 0 ) { // 第一步
                            minWindow = (i - startIndex + 1) < minWindow.length() ? s.substring(startIndex, i + 1) : minWindow;
                            charToCount.put( sChar, sCount + 1 );
                            startIndex ++;
                            find = true;

                            if ( sCount + 1 > 0 ) {
                                // 这个时候不能判断totalTCount 大于0， 然后break掉
                                // 因为从当前字符开始后还有不在t字符串中的字符需要通过循环中开始的条件剔除掉
                                totalTCount ++;
                            }
                        } else { // 第三步
                            break;
                        }
                    }

                    startIndex = startIndex > i ? null : startIndex;
                }
            }
        }

        return find ? minWindow : "";
    }
}
