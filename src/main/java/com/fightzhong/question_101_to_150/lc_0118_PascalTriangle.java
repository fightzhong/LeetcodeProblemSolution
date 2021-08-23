package com.fightzhong.question_101_to_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc_0118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add( Collections.singletonList( 1 ) );

        if ( numRows >= 2 ) {
            Integer[] lastRow = {1, 1};
            result.add( Arrays.asList( lastRow ) );

            int row = 3;
            while ( row <= numRows ) {
                Integer[] data = new Integer[row];
                data[0] = 1;
                data[data.length - 1] = 1;

                int dataIndex = 1;
                int lastRowIndex = 0;
                while ( dataIndex < data.length - 1 ) {
                    data[dataIndex] = lastRow[lastRowIndex] + lastRow[ ++ lastRowIndex];
                    dataIndex ++;
                }

                result.add( Arrays.asList( data ) );
                lastRow = data;
                row ++;
            }
        }

        return result;
    }
}
