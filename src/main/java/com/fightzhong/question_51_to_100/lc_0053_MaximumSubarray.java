package com.fightzhong.question_51_to_100;

public class lc_0053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxTotal = nums[0];
        int curTotal = nums[0];
        for ( int i = 1; i < nums.length; i ++ ) {
            curTotal = curTotal < 0 ? nums[i] : curTotal + nums[i];
            maxTotal = Math.max( maxTotal, curTotal );
        }

        return maxTotal;
    }
}
