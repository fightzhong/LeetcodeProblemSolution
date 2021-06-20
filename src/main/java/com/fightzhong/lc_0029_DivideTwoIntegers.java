package com.fightzhong;

import java.util.Random;

public class lc_0029_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if ( dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE ) {
            return 1;
        } else if ( divisor == Integer.MIN_VALUE ) {
            return 0;
        } else if ( dividend == Integer.MIN_VALUE ){
            if ( divisor == -1 ) {
                return Integer.MAX_VALUE;
            }

            int result1 = positiveDivide(sum(Integer.MIN_VALUE, 1), divisor);

            return sum(
                    result1,
                    positiveDivide( subject(dividend, multi(result1, divisor)) , divisor)
            );
        } else {
            return positiveDivide( dividend, divisor );
        }
    }

    public int positiveDivide(int dividend, int divisor) {
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = dividend >= 0 ? dividend : sum(~dividend, 1);
        divisor = divisor >= 0 ? divisor : sum(~divisor, 1);

        int result = 0;
        while ( dividend >= divisor ) {
            int leftCount = 0;
            while ( divisor << sum(leftCount, 1) >= 0 && dividend >= (divisor << sum(leftCount, 1)) ) {
                leftCount ++;
            }

            dividend = subject( dividend, divisor << leftCount );
            result = sum(result, 1 << leftCount);
        }

        return positive ? result : sum(~result, 1);
    }

    public int multi(int a, int b) {
        if ( a == 0 || b == 0 ) {
            return 0;
        }

        boolean positive = (a > 0 && b > 0) || (a < 0 && b < 0);
        a = a > 0 ? a : sum(~a, 1);
        b = b > 0 ? b : sum(~b, 1);

        int result = 0;
        while ( b != 0 ) {
            result = sum(result, (b & 1) == 0 ? 0 : a);
            a = a << 1;
            b = b >> 1;
        }

        return positive ? result : sum(~result, 1);
    }

    public int sum(int a, int b) {
        if ( b == 0 ) {
            return a;
        }

        int sum1 = a ^ b;
        int sum2 = (a & b) << 1;
        return sum(sum1, sum2);
    }

    public int subject(int a, int b) {
        return sum(a, sum(~b, 1));
    }
}
