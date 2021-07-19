package com.fightzhong.question_51_to_100;

public class lc_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int result = 0;

        int index = s.length() - 1;
        while ( index >= 0 ) {
            if ( s.charAt( index ) != ' ' ) {
                result ++;
            } else if ( result > 0 ) {
                return result;
            }

            index --;
        }

        return result;
    }
}
