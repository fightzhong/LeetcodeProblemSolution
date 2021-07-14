package com.fightzhong.question_1_to_50;

public class lc_0045_JumpGameII {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;

        for ( int i = nums.length - 2; i >= 0; i -- ) {
            int min = Integer.MAX_VALUE;
            for ( int j = 1; j <= nums[i]; j ++ ) {
                int value = dp[i + j] + 1;
                value = value < 0 ? Integer.MAX_VALUE : value;
                min = Math.min( min, value );
            }

            dp[i] = min;
        }

        return dp[0];
    }
}
