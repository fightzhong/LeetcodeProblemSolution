package com.fightzhong.question_1_to_50;

import java.util.ArrayList;
import java.util.List;

public class lc_0009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if ( x < 0 ) {
            return false;
        } else if ( x == 0 ) {
            return true;
        }

        List<String> interList = new ArrayList<>();
        while ( x != 0 ) {
            interList.add( String.valueOf( x % 10 ) );
            x /= 10;
        }

        int left = 0;
        int right = interList.size() - 1;
        while ( left < right ) {
            if ( !interList.get( left ).equals( interList.get( right ) ) ) {
                return false;
            }

            left ++;
            right --;
        }

        return true;
    }
}
