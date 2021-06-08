package com.fightzhong;

import java.util.HashMap;
import java.util.Map;

public class lc_0013_RomanToInteger {
    private class Mapping {
        private int value;

        private String str;

        public Mapping(int value, String str) {
            this.value = value;
            this.str = str;
        }
    }

    public int romanToInt(String s) {
        Mapping[] data = new Mapping[]{
                new Mapping(1, "I"),
                new Mapping(4, "IV"),
                new Mapping(5, "V"),
                new Mapping(9, "IX"),
                new Mapping(10, "X"),
                new Mapping(40, "XL"),
                new Mapping(50, "L"),
                new Mapping(90, "XC"),
                new Mapping(100, "C"),
                new Mapping(400, "CD"),
                new Mapping(500, "D"),
                new Mapping(900, "CM"),
                new Mapping(1000, "M")
        };

        int result = 0;
        int dIndex = data.length - 1;
        for ( int i = 0; i < s.length(); i ++ ) {
            String cur = String.valueOf(s.charAt( i ));
            while ( true ) {
                Mapping mapping = data[dIndex];
                if ( mapping.str.equals( cur ) ) {
                    result += mapping.value;
                    break;
                } else if ( (i + 1 < s.length() && mapping.str.equals( String.valueOf( s.charAt( i ) ) + s.charAt( i + 1 ) ) ) ) {
                    result += mapping.value;
                    i ++;
                    break;
                }
                dIndex --;
            }
        }

        return result;
    }
}
