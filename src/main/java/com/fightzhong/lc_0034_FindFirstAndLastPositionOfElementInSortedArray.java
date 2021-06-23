package com.fightzhong;

public class lc_0034_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if ( nums.length == 0 ) {
            return new int[]{-1, -1};
        }

        return searchRange( nums, 0, nums.length - 1, target );
    }

    public int[] searchRange(int[] nums, int left, int right, int target) {
        if ( target < nums[left] || target > nums[right] ) {
            return new int[]{-1, -1};
        } else if ( left == right ) {
            return target == nums[left] ? new int[]{left, left} : new int[]{-1, -1};
        }

        int middleIndex = (right - left) / 2 + left;
        int[] result1 = searchRange(nums, left, middleIndex, target);
        int[] result2 = searchRange( nums, middleIndex + 1, right, target );
        return merge(result1, result2);
    }

    private int[] merge(int[] r1, int[] r2) {
        if ( r1[0] == -1 ) {
            return r2;
        } else if ( r2[0] == -1 ) {
            return r1;
        }

        return new int[]{ Math.min(r1[0], r2[0]), Math.max(r1[1], r2[1]) };
    }
}
