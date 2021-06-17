package com.fightzhong;

public class lc_0026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int pre = 1;
        for ( int i = 1; i < nums.length; i ++ ) {
            if ( nums[i] == nums[i - 1] ) {
                length --;
            } else {
                nums[pre ++] = nums[i];
            }
        }

        return length;
    }
}
