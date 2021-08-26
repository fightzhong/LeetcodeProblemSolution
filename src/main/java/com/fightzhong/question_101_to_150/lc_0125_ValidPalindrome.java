package com.fightzhong.question_101_to_150;

public class lc_0125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while ( left < right ) {
            char leftC = s.charAt( left );
            char rightC = s.charAt( right );

            if ( !isNumber(leftC) && !isLetter( leftC ) && !isNumber(rightC) && !isLetter( rightC ) ) {
                left ++;
                right --;
            } else if ( !isNumber(leftC) && !isLetter( leftC ) ) {
                left ++;
            } else if ( !isNumber(rightC) && !isLetter( rightC ) ) {
                right --;
            } else if ( isNumber(leftC) && isNumber(rightC) ) {
                if ( leftC != rightC ) {
                    return false;
                }

                left ++;
                right --;
            } else if ( isLetter( leftC ) && isLetter( rightC ) ) {
                if ( leftC == rightC || Math.abs(leftC - rightC) == 32 ) {
                    left ++;
                    right --;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }

    private boolean isLetter(char c) {
        return ( c >= 65 && c <= 90 ) || ( c >= 97 && c <= 122 );
    }
}
