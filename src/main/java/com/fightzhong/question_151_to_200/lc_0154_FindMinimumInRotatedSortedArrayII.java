package com.fightzhong.question_151_to_200;

public class lc_0154_FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if ( nums.length == 1 || nums[0] < nums[nums.length - 1] ) {
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;
        while ( true ) {
            if ( l + 1 == r ) {
                return Math.min(nums[l], nums[r]);
            }

            int mid = l + (r - l) / 2;
            if ( nums[l] == nums[mid] ) {
                l ++;
            } else if ( nums[r] == nums[mid] ) {
                r --;
            } else if ( nums[l] < nums[mid] ) {
                l = mid;
            } else {
                r = mid;
            }
        }
    }
}
