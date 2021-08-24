package com.fightzhong.question_101_to_150;

import java.util.ArrayList;
import java.util.List;

public class lc_0120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> result = minimumTotal( triangle, 0 );
        return result.get( 0 );
    }

    private List<Integer> minimumTotal(List<List<Integer>> triangle, int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if ( rowIndex == triangle.size() - 1 ) {
            result.addAll( triangle.get( rowIndex ) );
            return result;
        }

        List<Integer> nextResult = minimumTotal( triangle, rowIndex + 1 );
        List<Integer> curRowValue = triangle.get( rowIndex );
        for ( int i = 0; i < curRowValue.size(); i ++ ) {
            int min = Math.min( nextResult.get( i ), nextResult.get( i + 1 ) );
            result.add( min + curRowValue.get( i ) );
        }

        return result;
    }
}
