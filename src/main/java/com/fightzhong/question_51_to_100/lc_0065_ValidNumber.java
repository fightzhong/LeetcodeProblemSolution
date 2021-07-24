package com.fightzhong.question_51_to_100;

import java.util.Arrays;

public class lc_0065_ValidNumber {
    public static void main(String[] args) {
//        String[] data = {
//                "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"
//        };
        String[] data = {
                "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", "6+1"
        };

        lc_0065_ValidNumber validNumber = new lc_0065_ValidNumber();
        for ( String s: data ) {
            if ( validNumber.isNumber( s ) ) {
                System.out.println( s );
            }
        }
    }

    public boolean isNumber(String s) {
        if ( s.length() == 0 ) {
            return false;
        }

        int letterCount = 0;
        int letterIndex = -1;
        for ( int i = 0; i < s.length(); i ++ ) {
            char c = s.charAt(i);
            if ( ( c >= 97 && c <= 122 ) || ( c >= 65 && c <= 90 ) ) {
                letterCount ++;
                if ( c != 'e' && c != 'E' ) {
                    return false;
                }

                letterIndex = i;
            }
        }

        if ( letterCount > 1 || letterIndex == s.length() - 1 ) {
            return false;
        }

        if ( letterIndex != -1 ) {
            String[] splitArr = s.split(String.valueOf(s.charAt(letterIndex)));
            return isANumber( splitArr[0] ) && isInteger( splitArr[1] );
        } else {
            return isANumber( s );
        }
    }

    /**
     * 判断是不是一个整数(包括正整数和负整数)
     */
    private boolean isInteger(String str) {
        if ( str.length() == 0 ) {
            return false;
        }

        int numberCount = 0;
        int pointCount = 0;
        int addOrSubjectSymbolCount = 0;
        int addOrSubjectSymbolIndex = -1;
        for ( int i = 0; i < str.length(); i ++ ) {
            char c = str.charAt( i );
            if ( c >= 48 && c <= 57 ) {
                numberCount ++;
            } else if ( c == '.' ) {
                pointCount ++;
            } else {
                addOrSubjectSymbolCount ++;
                addOrSubjectSymbolIndex = i;
            }
        }

        return numberCount != 0 && pointCount <= 0 && addOrSubjectSymbolCount <= 1 &&
                (addOrSubjectSymbolIndex == -1 || addOrSubjectSymbolIndex == 0 );
    }

    /**
     * 判断是不是一个数字, 包括整数、小数
     */
    private boolean isANumber(String str) {
        if ( str.length() == 0 ) {
            return false;
        }

        int numberCount = 0;
        int pointCount = 0;
        int addOrSubjectSymbolCount = 0;
        int addOrSubjectSymbolIndex = -1;
        for ( int i = 0; i < str.length(); i ++ ) {
            char c = str.charAt( i );
            if ( c >= 48 && c <= 57 ) {
                numberCount ++;
            } else if ( c == '.' ) {
                pointCount ++;
            } else {
                addOrSubjectSymbolCount ++;
                addOrSubjectSymbolIndex = i;
            }
        }

        return numberCount != 0 && pointCount <= 1 && addOrSubjectSymbolCount <= 1 &&
                (addOrSubjectSymbolIndex == -1 || addOrSubjectSymbolIndex == 0 );
    }
}
