package com.fightzhong.question_51_to_100;

public class lc_0069_Sqrt {
    public static void main(String[] args) {
        new lc_0069_Sqrt().mySqrt( 36 );
    }

    public int mySqrt(int x) {
        long left = 0;
        long right = x;

        while ( right - left >= 5 ) {
            long mid = (left + right) / 2;
            long midMul = mid * mid;
            if ( midMul < x ) {
                left = mid;
            } else if ( midMul > x ) {
                right = mid;
            } else if ( midMul == x ) {
                return (int)midMul;
            }
        }

        while ( (left + 1) * (left + 1) <= x ) {
            left ++;
        }

        return (int)left;
    }
}
