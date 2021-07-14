package com.fightzhong.question_1_to_50;

import java.util.ArrayList;
import java.util.List;

public class lc_0046_Permutations {
    public static void main(String[] args) {
        new lc_0046_Permutations().permute( new int[]{1, 2, 3} );
    }

    public List<List<Integer>> permute(int[] nums) {
        return permute( nums, 0 );
    }

    public List<List<Integer>> permute(int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if ( index == nums.length - 1 ) {
            List<Integer> data = new ArrayList<>();
            data.add( nums[index] );
            result.add( data );
            return result;
        }

        for ( int i = index; i < nums.length; i ++ ) {
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;

            List<List<Integer>> data = permute( nums, index + 1 );
            for ( List<Integer> item: data ) {
                item.add( nums[index] );
            }

            result.addAll( data );

            temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }

        return result;
    }
}
