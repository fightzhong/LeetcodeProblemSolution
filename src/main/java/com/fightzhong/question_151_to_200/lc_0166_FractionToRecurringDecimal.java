package com.fightzhong.question_151_to_200;

import java.util.HashMap;
import java.util.Map;

public class lc_0166_FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println( new lc_0166_FractionToRecurringDecimal().fractionToDecimal( -2147483648, 1 ) );;
//        System.out.println( -4 % 333 );
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if ( numerator == 0 ) {
            return "0";
        }

        String result = "";
        Map<Long, Integer> numeratorToStrLength = new HashMap<>();
        Integer circulationNumeratorLengthIndex = null;
        long newNumerator = Math.abs((long)numerator);
        long newDenominator = Math.abs((long)denominator);
        boolean decimal = false;
        while ( newNumerator != 0 ) {
            circulationNumeratorLengthIndex = numeratorToStrLength.get( newNumerator );
            if ( circulationNumeratorLengthIndex != null ) {
                break;
            }

            if ( !decimal && newNumerator < newDenominator ) {
                result += ".";
                decimal = true;
            }

            numeratorToStrLength.put( newNumerator, result.length() );
            while ( newNumerator < newDenominator ) {
                newNumerator *= 10;
                if ( newNumerator < newDenominator ) {
                    result += "0";
                } else {
                    break;
                }
            }

            long value = newNumerator / newDenominator;
            long remain = newNumerator % newDenominator;

            result += value;
            if ( remain == 0 ) {
                break;
            }

            newNumerator = remain;
        }

        if ( circulationNumeratorLengthIndex != null ) {
            result = result.substring( 0, circulationNumeratorLengthIndex ) + "(" + result.substring( circulationNumeratorLengthIndex ) + ")";
        }

        result = result.charAt(0) == '.' ? "0" + result : result;
        return (numerator < 0 && denominator < 0) ||
                (numerator > 0 && denominator > 0) ? result : "-" + result;
    }
}
