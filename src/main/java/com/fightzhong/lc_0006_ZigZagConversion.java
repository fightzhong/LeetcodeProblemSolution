package com.fightzhong;

import java.util.Arrays;

public class lc_0006_ZigZagConversion {
    public static void main(String[] args) {
        System.out.println( new lc_0006_ZigZagConversion().
                convert_2( "PAYPALISHIRING", 1 ) );
    }

    public String convert_2(String s, int numRows){
        String[] data = new String[numRows];
        Arrays.fill(data, "");
        int i = 0;
        int x = 0;
        int y = 0;
        while ( i < s.length() ) {
            // 完整列填充
            while ( x < numRows && i < s.length() ) {
                data[x] += s.charAt(i++);
                x ++;
            }

            // 部分列填充
            x -= 2;
            while ( x > 0 && i < s.length() ) {
                data[x] += s.charAt(i++);
                x --;
            }

            x = 0;
        }

        StringBuilder result = new StringBuilder();
        for ( String item: data ) {
            result.append(item);
        }

        return result.toString();
    }

    public String convert_1(String s, int numRows) {
        int column = getColumn(s, numRows);
        Character[][] data = new Character[numRows][column];

        int i = 0;
        int x = 0;
        int y = 0;
        while ( i < s.length() ) {
            // 完整列填充
            while ( x < numRows && i < s.length() ) {
                data[x][y] = s.charAt(i++);
                x ++;
            }

            // 部分列填充
            x -= 2;
            y ++;
            while ( x > 0 && y < column && i < s.length() ) {
                data[x][y] = s.charAt(i++);
                x --;
                y ++;
            }

            x = 0;
        }

        return buildString(data);
    }

    private String buildString(Character[][] data) {
        StringBuilder builder = new StringBuilder();
        for (Character[] datum : data) {
            for (int j = 0; j < data[0].length; j++) {
                if (datum[j] != null) {
                    builder.append(datum[j]);
                }
            }
        }

        return builder.toString();
    }

    private int getColumn(String s, int numRows) {
        int column = 0;
        int length = s.length();
        while ( length > 0 ) {
            column ++;
            length -= numRows;

            int i = numRows - 2;
            while ( length > 0 && i > 0 ) {
                length --;
                i --;
                column ++;
            }
        }

        return column;
    }
}
