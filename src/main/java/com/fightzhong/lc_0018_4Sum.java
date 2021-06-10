package com.fightzhong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class lc_0018_4Sum {
    public static void main(String[] args) {
        new lc_0018_4Sum().fourSum( new int[]{-3,-2,-1,0,0,1,2,3}, 0 );
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort( nums );

        List<List<Integer>> result = new ArrayList<>();
        for ( int i = 0; i < nums.length - 3; i ++ ) {
            if ( (i - 1 >= 0 && nums[i - 1] == nums[i]) || (nums[i] > target && nums[i] > 0) ) {
                continue;
            }

            int remain = target - nums[i];
            for ( int x = i + 1; x < nums.length - 2; x ++ ) {
                if ( ( x - 1 >= i + 1 && nums[x] == nums[x - 1] ) || (nums[x] > remain && nums[x] > 0) ) {
                    continue;
                }

                int leftIndex = x + 1;
                int rightIndex = nums.length - 1;
                Integer lastLeftValue = null;
                while ( leftIndex < rightIndex ) {
                    if ( lastLeftValue != null && lastLeftValue == nums[leftIndex]  ) {
                        leftIndex ++;
                        continue;
                    }

                    int total = nums[i] + nums[x] + nums[leftIndex] + nums[rightIndex];
                    if ( total == target ) {
                        result.add( Arrays.asList( nums[i], nums[x], nums[leftIndex], nums[rightIndex] ) );
                        lastLeftValue = nums[leftIndex];
                        leftIndex ++;
                        rightIndex --;
                    } else if ( total < target ) {
                        leftIndex ++;
                    } else {
                        rightIndex --;
                    }
                }
            }
        }

        return result;
    }
}
