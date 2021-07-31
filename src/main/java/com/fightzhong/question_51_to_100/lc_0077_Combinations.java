package com.fightzhong.question_51_to_100;

import java.util.ArrayList;
import java.util.List;

public class lc_0077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        return get( 1, n, k, 1 );
    }

    private List<List<Integer>> get (int l, int r, int k, int curK) {
        List<List<Integer>> result = new ArrayList<>();
        if ( r - l < k - curK ) {
            return result;
        } else if ( curK == k ) {
            while ( l <= r ) {
                List<Integer> data = new ArrayList<>();
                data.add( l );
                result.add( data );
                l ++;
            }

            return result;
        }

        for ( int i = l; i <= r; i ++ ) {
            List<List<Integer>> curResult = get( i + 1, r, k, curK + 1 );
            for ( List<Integer> list: curResult ) {
                list.add( i );
                result.add( list );
            }
        }

        return result;
    }
}
