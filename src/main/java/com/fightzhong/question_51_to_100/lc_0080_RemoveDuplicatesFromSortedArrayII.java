package com.fightzhong.question_51_to_100;

public class lc_0080_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if ( nums.length <= 2 ) {
            return nums.length;
        }

        int left = 2;
        int cur = 2;
        while ( cur < nums.length ) {
            // 重复的情况
            if ( nums[cur] == nums[left - 1] && nums[cur] == nums[left - 2] ) {
                cur ++;
            } else {
                nums[left++] = nums[cur++];
            }
        }

        return left;
    }
}
