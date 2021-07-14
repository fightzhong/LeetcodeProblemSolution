package com.fightzhong.question_1_to_50;

public class lc_0027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int preIndex = 0;
        int length = 0;
        for ( int i = 0; i < nums.length; i ++ ) {
            if ( nums[i] != val ) {
                nums[preIndex ++] = nums[i];
                length ++;
            }
        }

        return length;
    }
}
