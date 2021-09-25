package com.fightzhong.question_151_to_200;

public class lc_0152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if ( nums.length == 0 ) {
            return 0;
        }

        int max = nums[nums.length - 1];
        int min = nums[nums.length - 1];
        int result = max;
        for ( int i = nums.length - 2; i >= 0; i -- ) {
            int v1 = nums[i] * max;
            int v2 = nums[i] * min;

            max = Math.max( nums[i], Math.max( v1, v2 ) );
            min = Math.min( nums[i], Math.min( v1, v2 ) );
            result = Math.max( max, result );
        }

        return result;
    }
}
