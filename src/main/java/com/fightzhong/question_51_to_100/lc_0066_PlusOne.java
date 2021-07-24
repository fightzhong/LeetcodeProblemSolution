package com.fightzhong.question_51_to_100;

import java.util.ArrayList;

public class lc_0066_PlusOne {
    public int[] plusOne(int[] digits) {
        int base = 1;
        for ( int i = digits.length - 1; i >= 0; i -- ) {
            if ( digits[i] == 9 && base != 0 ) {
                digits[i] = 0;
            } else {
                digits[i] += base;
                base = 0;
            }
        }

        int[] result = digits;
        if ( base != 0 ) {
            result = new int[digits.length + 1];
            result[0] = base;
            System.arraycopy( digits, 0, result, 1, result.length - 1 );
        }

        return result;
    }
}
