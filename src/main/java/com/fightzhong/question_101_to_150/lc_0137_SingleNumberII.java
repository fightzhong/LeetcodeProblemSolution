package com.fightzhong.question_101_to_150;

import java.util.HashMap;
import java.util.Map;

public class lc_0137_SingleNumberII {
    public int singleNumber(int[] nums) {
        int total = 0;
        for ( int i = 0; i < 32; i ++ ) {
            int count = 0;
            for ( int num: nums ) {
                count += ( (num >>> i) & 1 );
            }

            int value = count % 3 == 0 ? 0 : 1;
            total += value << i;
        }

        return total;
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num: nums ) {
            map.merge(num, 1, Integer::sum);
        }

        for ( int num: nums ) {
            if ( map.get( num ) == 1 ) {
                return num;
            }
        }

        return -1;
    }
}
