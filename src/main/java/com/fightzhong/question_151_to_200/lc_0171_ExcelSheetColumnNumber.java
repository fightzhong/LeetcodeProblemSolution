package com.fightzhong.question_151_to_200;

public class lc_0171_ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println( new lc_0171_ExcelSheetColumnNumber().titleToNumber( "FXSHRXW" ) );
    }

    public int titleToNumber(String columnTitle) {
        int result = 0;
        int multi = 1;
        for ( int i = columnTitle.length() - 1; i >= 0; i -- ) {
            int curR = columnTitle.charAt(i) - 64;
            result += curR * multi;
            multi = multi * 26;
        }

        return result;
    }
}
