package com.fightzhong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_0039_CombinationSum {
    public static void main(String[] args) {
        System.out.println( new lc_0039_CombinationSum().combinationSum( new int[]{2,3,6,7}, 7 ) );
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort( candidates );

        return combinationSum( candidates, 0, target );
    }

    private List<List<Integer>>  combinationSum(int[] candidates, int index, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if ( index == candidates.length || target < 0 ) {
            return result;
        } else if ( target == candidates[index] ) {
            List<Integer> data = new ArrayList<>();
            data.add( candidates[index] );
            result.add( data );
            return result;
        } else {
            int curValue = candidates[index];

            // 选index对应的值
            List<List<Integer>> temp = combinationSum( candidates, index, target - curValue );
            for ( List<Integer> item: temp ) {
                item.add(curValue);
            }
            result.addAll(temp);

            // 不选index对应的值
            result.addAll( combinationSum( candidates, index + 1, target ) );

            return result;
        }
    }
}
