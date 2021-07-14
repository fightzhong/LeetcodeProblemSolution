package com.fightzhong.question_1_to_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_0040_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort( candidates );

        return combinationSum2( candidates, 0, target );
    }

    private List<List<Integer>>  combinationSum2(int[] candidates, int index, int target) {
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
            List<List<Integer>> temp = combinationSum2( candidates, index + 1, target - curValue );
            for ( List<Integer> item: temp ) {
                item.add(curValue);
            }
            result.addAll(temp);

            // 不选index对应的值
            int nextIndex = index + 1;
            while (nextIndex < candidates.length && candidates[nextIndex] == curValue) {
                nextIndex ++;
            }
            result.addAll( combinationSum2( candidates, nextIndex, target ) );

            return result;
        }
    }
}
