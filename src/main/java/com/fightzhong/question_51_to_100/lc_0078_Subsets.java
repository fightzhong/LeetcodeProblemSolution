package com.fightzhong.question_51_to_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc_0078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = subsets( 0, nums );
        result.add( new ArrayList<>() );
        return result;
    }

    private List<List<Integer>> subsets(int index, int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if ( index == nums.length - 1 ) {
            List<Integer> data = new ArrayList<>();
            data.add( nums[index] );
            result.add( data );
            return result;
        }

        // 当前元素是一个子集
        result.add(Collections.singletonList(nums[index]));
        List<List<Integer>> curResult = subsets( index + 1, nums );
        for ( List<Integer> list: curResult ) {
            List<Integer> clone = new ArrayList<>( list );
            clone.add( nums[index] );
            result.add( list );
            result.add( clone );
        }

        return result;
    }
}
