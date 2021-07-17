package com.fightzhong.question_51_to_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lc_0056_MergeIntervals {
    public static void main(String[] args) {
        int[][] data = new int[][] {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };

        System.out.println( Arrays.deepToString( new lc_0056_MergeIntervals().merge( data ) ) );
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort( intervals, Comparator.comparingInt( arr -> arr[0] ));
        List<int[]> arrList = new ArrayList<>();

        int[] lastArr = null;
        for ( int[] arr: intervals ) {
            if ( lastArr == null ) {
                lastArr = arr;
                arrList.add( arr );
            } else {
                if ( lastArr[1] < arr[0] ) {
                    arrList.add( arr );
                    lastArr = arr;
                } else {
                    lastArr[1] = Math.max( arr[1], lastArr[1] );
                }
            }
        }

        int[][] result = new int[arrList.size()][2];
        int index = 0;
        for ( int[] arr: arrList ) {
            result[index ++] = arr;
        }

        return result;
    }
}
