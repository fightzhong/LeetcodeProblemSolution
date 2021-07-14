package com.fightzhong.question_1_to_50;

public class lc_0041_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            while ( true ) {
                if ( nums[i] == i + 1 || nums[i] > nums.length || nums[i] <= 0 ) {
                    break;
                }

                int targetIndex = nums[i] - 1;
                int temp = nums[targetIndex];
                if ( temp == nums[i] ) {
                    break;
                }

                nums[targetIndex] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i ++) {
            if ( i + 1 != nums[i] ) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
