package com.fightzhong.question_151_to_200;

public class lc_0162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while ( l < r ) {
            int mid = l + (r - l) / 2;
            boolean maxThanLeft = mid - 1 < 0 || nums[mid] > nums[mid - 1];
            boolean maxThanRight = mid + 1 >= nums.length || nums[mid] > nums[mid + 1];

            if ( maxThanLeft && maxThanRight ) {
                return mid;
            } else if ( maxThanLeft ) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
