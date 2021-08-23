package com.fightzhong.question_101_to_150;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc_0119_PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if ( rowIndex == 0 ) {
            return Collections.singletonList( 1 );
        }

        Integer[] lastRow = {1, 1};
        int curRowIndex = 2;
        while ( curRowIndex <= rowIndex ) {
            Integer[] data = new Integer[curRowIndex + 1];
            data[0] = 1;
            data[data.length - 1] = 1;

            int dataIndex = 1;
            int lastRowIndex = 0;

            while ( dataIndex < data.length - 1 ) {
                data[dataIndex] = lastRow[lastRowIndex] + lastRow[ ++ lastRowIndex];
                dataIndex ++;
            }

            lastRow = data;
            curRowIndex ++;
        }

        return Arrays.asList( lastRow );
    }
}
