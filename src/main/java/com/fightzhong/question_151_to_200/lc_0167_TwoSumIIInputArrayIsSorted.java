package com.fightzhong.question_151_to_200;

public class lc_0167_TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while ( l < r ) {
            int number = numbers[l] + numbers[r];
            if ( number == target ) {
                break;
            } else if ( number < target ) {
                l ++;
            } else {
                r --;
            }
        }

        return new int[]{l + 1, r + 1};
    }
}
