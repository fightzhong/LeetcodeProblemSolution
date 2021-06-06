package com.fightzhong;

import java.util.LinkedList;

public class lc_0008_StringToInteger {
    public static void main(String[] args) {
        int i = 2147483646;
        System.out.println( new lc_0008_StringToInteger().myAtoi("2147483646") );
    }

    public int myAtoi(String s) {
        if ( s == null || s.length() == 0 || (s = s.trim()).length() == 0 ) {
            return 0;
        }

        boolean isPositive = s.charAt(0) != '-';
        LinkedList<Integer> integerContainer = new LinkedList<>();
        for ( int i = 0; i < s.length(); i ++ ) {
            char curChar = s.charAt(i);
            if ( i == 0 && ( curChar == '-' || curChar == '+' ) ) {
                continue;
            } else if ( curChar < 48 || curChar > 57 ) {
                break;
            }

            integerContainer.add( curChar - 48 );
        }

        while ( integerContainer.size() > 0 && integerContainer.getFirst() == 0 ) {
            integerContainer.removeFirst();
        }

        int base = isPositive ? 1 : -1;
        int result = 0;
        int lastBase = base;
        while ( integerContainer.size() > 0 ) {
            if ( base != lastBase && base / 10 != lastBase ) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            Integer i = integerContainer.removeLast();
            int lastValue = i * base;
            if ( lastValue != 0 && lastValue / base != i ) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result += lastValue;
            if ( isPositive && result < 0 ) {
                return Integer.MAX_VALUE;
            } else if ( !isPositive && result > 0 ) {
                return Integer.MIN_VALUE;
            }

            lastBase = base;
            base *= 10;
        }

        return result;
    }
}
