package com.fightzhong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc_0047_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
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

        Set<Integer> usedSet = new HashSet<>();
        for ( int i = index; i < nums.length; i ++ ) {
            if ( !usedSet.add( nums[i] ) ) {
                continue;
            }

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
