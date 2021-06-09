package com.fightzhong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_0017_LetterCombinationsOfaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[][] cache = new String[][]{
                {}, {},
                { "a", "b", "c" },
                { "d", "e", "f" },
                { "g", "h", "i" },
                { "j", "k", "l" },
                { "m", "n", "o" },
                { "p", "q", "r", "s" },
                { "t", "u", "v" },
                { "w", "x", "y", "z" }
        };


        return letterCombinations( digits, 0, cache );
    }

    private List<String> letterCombinations(String digits, int curIndex, String[][] cache) {
        if ( digits.length() == 0 ) {
            return new ArrayList<>();
        } else if ( curIndex == digits.length() - 1 ) {
            return Arrays.asList( cache[Integer.parseInt(String.valueOf(digits.charAt(curIndex)))] );
        }

        List<String> data = letterCombinations( digits, curIndex + 1, cache );
        List<String> result = new ArrayList<>();
        String[] target = cache[Integer.parseInt(String.valueOf(digits.charAt(curIndex)))];
        for ( String s: target ) {
            for ( String y: data ) {
                result.add( s + y );
            }
        }

        return result;
    }
}
