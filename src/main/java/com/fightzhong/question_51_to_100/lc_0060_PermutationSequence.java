package com.fightzhong.question_51_to_100;

import java.util.ArrayList;
import java.util.List;

public class lc_0060_PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] singleGroup = {0, 1, 1, 2, 6, 24, 120, 720, 5040, 40320};
        int group = k % singleGroup[n] > 0 ? k / singleGroup[n] + 1 : k / singleGroup[n];
        int count = k - (group - 1) * singleGroup[n];

        String str = String.valueOf(group);
        boolean[] used = new boolean[n + 1];
        used[group] = true;
        return getPermutation( n, str, used, new int[]{0, count } );
    }

    // data[0] 当前遍历到了多少字符了, data[1] 表示目标是第几个字符
    public String getPermutation(int n, String str, boolean[] used, int[] data) {
        if ( n == str.length() ) {
            data[0] ++;
            return data[0] == data[1] ? str : null;
        }

        for (int i = 1; i <= n; i ++) {
            if ( used[i] ) {
                continue;
            }

            used[i] = true;

            String result = getPermutation( n, str + i, used, data );
            if ( result != null ) {
                return result;
            }

            used[i] = false;
        }

        return null;
    }
}
