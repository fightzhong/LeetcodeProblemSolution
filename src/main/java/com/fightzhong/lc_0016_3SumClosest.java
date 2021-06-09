package com.fightzhong;

import java.util.Arrays;

public class lc_0016_3SumClosest {
    public static void main(String[] args) {
        new lc_0016_3SumClosest().threeSumClosest( new int[]{-1,-1,1,1,3}, -1 );
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort( nums );

        int curIndex = 0;
        Integer result = null;
        Integer lastValue = null;
        while ( curIndex < nums.length - 2 ) {
            int curValue = nums[curIndex];
            if ( result != null && result > target && curValue > target ) {
                break;
            } else if ( lastValue != null && lastValue == curValue ) {
                curIndex ++;
                continue;
            }

            lastValue = curValue;
            int leftIndex = curIndex + 1;
            int rightIndex = nums.length - 1;
            while ( leftIndex < rightIndex ) {
                int sum = curValue + nums[leftIndex] + nums[rightIndex];
                if ( sum == target ) {
                    return target;
                } else if ( sum < target ) {
                    leftIndex ++;
                } else {
                    rightIndex --;
                }

                result = result == null ? sum :
                        Math.abs( sum - target ) < Math.abs( result - target ) ? sum : result;
            }

            curIndex ++;
        }

        assert result != null;
        return result;
    }
}
