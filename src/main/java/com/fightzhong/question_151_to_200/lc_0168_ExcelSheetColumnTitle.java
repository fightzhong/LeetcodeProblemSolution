package com.fightzhong.question_151_to_200;

public class lc_0168_ExcelSheetColumnTitle {
    private final String[] data = new String[] {
            "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"
    };

    public String convertToTitle(int columnNumber) {
        int baseValue = 26;
        String result = "";

        while ( true ) {
            if ( columnNumber <= 26 ) {
                result = data[columnNumber] + result;
                break;
            } else {
                int mod = columnNumber % 26;

                // 能被26整除
                if ( mod == 0 ) {
                    return convertToTitle( columnNumber, baseValue ) + result;
                } else {
                    columnNumber = columnNumber / 26;
                    result = data[mod] + result;
                }
                baseValue *= 26;
            }
        }

        return result;
    }

    private String convertToTitle(int columnNumber, int baseValue) {
        String result = "";
        while ( true ) {
            // 小于了当前层最大的值, 那么需要以上一层的baseValue进行相除才能得到
            if ( columnNumber <= baseValue ) {
                result = data[columnNumber / (baseValue / 26)] + result;
                break;
            } else {
                result = "Z" + result;
                columnNumber -= baseValue;
            }

            baseValue *= 26;
        }

        return result;
    }
}
