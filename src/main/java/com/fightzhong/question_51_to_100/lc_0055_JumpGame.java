package com.fightzhong.question_51_to_100;

import java.util.Arrays;

public class lc_0055_JumpGame {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[dp.length - 1] = true;

        for ( int i = dp.length - 2; i >= 0; i -- ) {
            boolean result = false;
            if ( dp.length - 1 - i <= nums[i] ) {
                result = true;
            } else {
                for ( int j = 1; j <= nums[i]; j ++ ) {
                    result = result | dp[i + j];
                }
            }

            dp[i] = result;
        }

        return dp[0];
    }
}
