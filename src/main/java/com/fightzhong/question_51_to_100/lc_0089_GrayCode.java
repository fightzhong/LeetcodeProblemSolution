package com.fightzhong.question_51_to_100;

import java.util.*;

public class lc_0089_GrayCode {
    public static void main(String[] args) {
        int[] data = {
                0,8,12,4,6,14,10,2,3,11,15,7,5,13,9,1
        };

        for ( int i: data ) {
            StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
            int needZeroCount = 4 - s.length();
            for ( int j = 0; j < needZeroCount; j ++ ) {
                s.insert(0, "0");
            }

            System.out.println( s );
        }
//        List<Integer> result = new ArrayList<>( 1 << 5 );
//        Collections.fill( result, 0 );
//        System.out.println( result.size() );
//        System.out.println( result );

//        System.out.println( Integer.parseUnsignedInt( "0010", 2 ) );;
    }

    public List<Integer> grayCode(int n) {
        if ( n == 0 ) {
            return Arrays.asList( 0 );
        }

        String binaryStr = "";
        for (int i = 0; i < n; i ++) {
            binaryStr += "0";
        }

        int size = 1 << n;
        List<Integer> result = new ArrayList<>( 1 << n );
        for ( int i = 0; i < size; i ++ ) {
            result.add(0);
        }

        Set<String> used = new HashSet<>();
        used.add( binaryStr );
        grayCode( binaryStr, result, 1, used );

        return result;
    }

    private boolean grayCode(String binaryStr, List<Integer> result, int index, Set<String> used) {
        if ( index == result.size() ) {
            return true;
        }

        for ( int i = 0; i < binaryStr.length(); i ++ ) {
            String b1 = binaryStr.substring(0, i);
            String b2 = i + 1 == binaryStr.length() ? "" : binaryStr.substring(i + 1, binaryStr.length());
            char curC = binaryStr.charAt(i);

            String newStr = b1 + ( curC == '0' ? '1' : '0' ) + b2;
            if ( !used.contains( newStr ) ) {
                used.add( newStr );
                result.set( index ++, Integer.parseUnsignedInt( newStr, 2 ) );
                boolean r = grayCode( newStr, result, index, used );
                if ( r ) {
                    return r;
                }
            }
        }

        return false;
    }
}
