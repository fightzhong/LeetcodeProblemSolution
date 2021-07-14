package com.fightzhong.question_1_to_50;

import java.util.HashMap;
import java.util.Map;

public class lc_0012_IntegerToRoman {
    private class Mapping {
        private int value;

        private String str;

        public Mapping(int value, String str) {
            this.value = value;
            this.str = str;
        }
    }

    public String intToRoman(int num) {
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
        int dIndex = data.length - 1;
        StringBuilder result = new StringBuilder();
        while ( num != 0 ) {
            Mapping mapping = data[dIndex];
            if ( num < mapping.value ) {
                dIndex --;
                continue;
            }

            result.append(mapping.str);
            num -= mapping.value;
        }

        return result.toString();
    }
}
