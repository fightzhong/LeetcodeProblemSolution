package com.fightzhong.question_51_to_100;

public class lc_0067_AddBinary {
    public static void main(String[] args) {
        new lc_0067_AddBinary().addBinary( "11", "1" );
    }

    public String addBinary(String a, String b) {
        if ( b.length() == 0 ) {
            return a;
        } else if ( a.length() == 0 ) {
            return b;
        }

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int base = 0;
        while ( aIndex >= 0 && bIndex >= 0 ) {
            char aChar = a.charAt( aIndex );
            char bChar = b.charAt( bIndex );
            if ( aChar == '1' && bChar == '1' ) {
                result.insert(0, base);
                base = 1;
            } else if ( aChar == '0' && bChar == '0' ) {
                result.insert(0, base);
                base = 0;
            } else if ( base == 0 ){
                result.insert(0, '1');
            } else {
                result.insert(0, '0');
                base = 1;
            }

            aIndex --;
            bIndex --;
        }

        if ( aIndex >= 0 ) {
            while ( aIndex >= 0 ) {
                char c = a.charAt( aIndex );
                if ( base == 1 && c == '1' ) {
                    result.insert(0, '0');
                    base = 1;
                } else if (base == 1){
                    result.insert(0, '1');
                    base = 0;
                } else {
                    result.insert(0, c);
                }

                aIndex --;
            }
        }

        if ( bIndex >= 0 ) {
            while ( bIndex >= 0 ) {
                char c = b.charAt( bIndex );
                if ( base == 1 && c == '1' ) {
                    result.insert(0, '0');
                    base = 1;
                } else if (base == 1){
                    result.insert(0, '1');
                    base = 0;
                } else {
                    result.insert(0, c);
                }

                bIndex --;
            }
        }

        if ( base > 0 ) {
            result.insert( 0, base );
        }

        return result.toString();
    }
}
