package com.fightzhong;

public class lc_0043_MultiplyStrings {
    public static void main(String[] args) {
        System.out.println( new lc_0043_MultiplyStrings().multiply( "123", "10" ) );
    }

    public String multiply(String num1, String num2) {
        String result = "";
        StringBuilder zero = new StringBuilder();
        for ( int i = num2.length() - 1; i >= 0; i -- ) {
            result = add(result, multiply(num1, num2.charAt(i) - 48) + zero);
            zero.append("0");
        }

        return result.charAt( 0 ) == '0' ? "0" : result.toString();
    }

    private String multiply(String num1, int base) {
        int temp = 0;
        StringBuilder result = new StringBuilder();
        int index = num1.length() - 1;
        while ( index >= 0 ) {
            int v = num1.charAt(index) - 48;
            int r = v * base + temp;

            temp = r / 10;
            result.insert(0, r % 10);
            index --;
        }

        if ( temp != 0 ) {
            result.insert(0, temp);
        }

        return result.charAt( 0 ) == '0' ? "0" : result.toString();
    }

    private String add(String num1, String num2) {
        int temp = 0;
        StringBuilder result = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        while ( index1 >= 0 || index2 >= 0 ) {
            int v1 = 0;
            if ( index1 >= 0 ) {
                v1 = (int)(num1.charAt(index1)) - 48;
                index1 --;
            }

            int v2 = 0;
            if ( index2 >= 0 ) {
                v2 = (int)(num2.charAt(index2)) - 48;
                index2 --;
            }

            int v = v1 + v2 + temp;
            temp = v / 10;
            result.insert(0, v % 10);
        }

        if ( temp != 0 ) {
            result.insert(0, temp);
        }

        return result.toString();
    }
}
