package com.fightzhong.question_51_to_100;

/**
 * 这道题考察的是二分法, 我下面这个解法是真的垃圾, 卒
 */
public class lc_0081_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int left = nums[0];
        if ( target < left ) {
            int index = nums.length - 1;
            while ( index >= 0 ) {
                if ( nums[index] < target ) {
                    return false;
                } else if ( nums[index] == target ) {
                    return true;
                } else {
                    index --;
                }
            }
        } else {
            int index = 0;
            while ( index < nums.length ) {
                if ( nums[index] > target ) {
                    return false;
                } else if ( nums[index] == target ) {
                    return true;
                } else {
                    index ++;
                }
            }
        }

        return false;
    }
}
