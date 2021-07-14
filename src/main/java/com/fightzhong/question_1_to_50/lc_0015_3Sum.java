package com.fightzhong.question_1_to_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort( nums );

        int curIndex = 0;
        List<List<Integer>> result = new ArrayList<>();
        Integer lastIndexValue = null;
        while ( curIndex < nums.length - 2 ) {
            if ( lastIndexValue != null && lastIndexValue == nums[curIndex] ) {
                curIndex ++;
                continue;
            } else if ( nums[curIndex] > 0 ) {
                break;
            }

            int remain = -nums[curIndex];
            int leftIndex = curIndex + 1;
            int rightIndex = nums.length - 1;
            Integer lastLeftIndexValue = null;
            while ( leftIndex < rightIndex ) {
                if ( lastLeftIndexValue != null && lastLeftIndexValue == nums[leftIndex] ) {
                    leftIndex ++;
                    continue;
                }

                int total = nums[leftIndex] + nums[rightIndex];
                if ( total == remain ) {
                    lastLeftIndexValue = nums[leftIndex];
                    result.add( Arrays.asList( nums[curIndex], nums[leftIndex], nums[rightIndex] ) );
                } else if ( total < remain ) {
                    leftIndex ++;
                } else {
                    rightIndex --;
                }
            }

            lastIndexValue = nums[curIndex];
            curIndex ++;
        }

        return result;
    }
}
