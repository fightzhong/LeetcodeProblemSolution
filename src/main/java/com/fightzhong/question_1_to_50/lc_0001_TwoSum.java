package com.fightzhong.question_1_to_50;

import java.util.HashMap;
import java.util.Map;

public class lc_0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap<>();
        int i = 0;
        for (int num: nums) {
            int remain = target - num;
            if (data.containsKey(remain)) {
                return new int[]{i, data.get(remain)};
            }

            data.put(num, i ++);
        }

        return null;
    }
}
