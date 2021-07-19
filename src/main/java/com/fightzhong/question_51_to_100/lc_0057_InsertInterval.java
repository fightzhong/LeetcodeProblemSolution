package com.fightzhong.question_51_to_100;

import java.util.LinkedList;
import java.util.List;

public class lc_0057_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] merge = new int[intervals.length + 1][2];
        int index = 0;
        boolean insert = false;
        for ( int[] interval: intervals ) {
            if ( interval[0] >= newInterval[0] && !insert ) {
                merge[index ++] = newInterval;
                insert = true;
            }

            merge[index ++] = interval;
        }

        if ( !insert ) {
            merge[index] = newInterval;
        }

        // 合并区间
        List<int[]> intervalList = new LinkedList<>();
        int[] lastInterval = merge[0];
        intervalList.add( merge[0] );

        for ( int i = 1; i < merge.length; i ++ ) {
            int[] cur = merge[i];

            // 不是合并的情况
            if ( cur[0] > lastInterval[1] ) {
                intervalList.add( cur );
                lastInterval = cur;
            } else {
                lastInterval[0] = Math.min( lastInterval[0], cur[0] );
                lastInterval[1] = Math.max( lastInterval[1], cur[1] );
            }
        }

        int[][] result = new int[intervalList.size()][2];
        index = 0;
        for ( int[] item: intervalList )  {
            result[index++] = item;
        }

        return result;
    }
}
