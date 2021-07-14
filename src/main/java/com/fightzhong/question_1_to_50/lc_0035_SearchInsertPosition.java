package com.fightzhong.question_1_to_50;

public class lc_0035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        for ( int i = 0; i < nums.length; i ++ ) {
            if ( nums[i] > target || nums[i] == target ) {
                return i;
            }
        }

        return nums.length;
    }
}
