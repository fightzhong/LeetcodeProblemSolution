package com.fightzhong.question_151_to_200;

import java.util.HashMap;
import java.util.Map;

public class lc_0169_MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = nums.length / 2;
        for ( int num: nums ) {
            Integer count = countMap.get(num);
            if ( count == null ) {
                count = 0;
            }

            countMap.put( num, count + 1 );

            if ( count + 1 > maxCount ) {
                return num;
            }
        }

        return -1;
    }
}
