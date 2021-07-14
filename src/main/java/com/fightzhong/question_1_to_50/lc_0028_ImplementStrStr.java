package com.fightzhong.question_1_to_50;

import java.util.Arrays;

public class lc_0028_ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new lc_0028_ImplementStrStr().arr("12351231235")));
    }

    public int strStr(String haystack, String needle) {
        if ( haystack.length() < needle.length() ) {
            return -1;
        }

        int[] arr = arr( needle );
        int haystackIndex = 0;
        int needleIndex = 0;
        while ( haystackIndex < haystack.length() && needleIndex < needle.length() ) {
            if ( haystack.charAt( haystackIndex ) == needle.charAt( needleIndex ) ) {
                haystackIndex ++;
                needleIndex ++;
            } else if ( needleIndex == 0 ) {
                haystackIndex ++;
            } else{
                int lastIndex = needleIndex - 1;
                while ( lastIndex >= 0 && haystack.charAt( haystackIndex ) != needle.charAt( lastIndex + 1 ) ) {
                    lastIndex = arr[lastIndex];
                }
                needleIndex = lastIndex + 1;
            }
        }

        return needleIndex != needle.length() ? -1 :
                haystackIndex - needleIndex;
    }

    private int[] arr(String str) {
        int[] result = new int[str.length()];
        if ( str.length() > 0 ) {
            result[0] = -1;
            for ( int i = 1; i < str.length(); i ++ ) {
                // 前一个字符的最长前缀和最长后缀的前缀索引 + 1就是后一个字符
                int preCharLastIndex = result[i - 1];
                while ( preCharLastIndex != -1 && str.charAt( preCharLastIndex + 1 ) != str.charAt( i ) ) {
                    preCharLastIndex = result[preCharLastIndex];
                }

                result[i] = str.charAt( preCharLastIndex + 1 ) == str.charAt( i ) ? preCharLastIndex + 1 : -1;
            }
        }

        return result;
    }
}
