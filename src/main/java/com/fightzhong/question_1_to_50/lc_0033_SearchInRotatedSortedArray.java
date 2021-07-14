package com.fightzhong.question_1_to_50;

public class lc_0033_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = new int[]{4,5,6,7,0,1,2};
        System.out.println( new lc_0033_SearchInRotatedSortedArray().search2(
                arr, 0
        ) );
    }

    public int search2(int[] nums, int target) {
        return search2( nums, 0, nums.length - 1, target );
    }

    public int search2(int[] nums, int start, int end, int target) {
        if ( start == end ) {
            return nums[start] == target ? start : -1;
        }

        if ( nums[end] > nums[start] ) {
            if ( target >= nums[start] && target <= nums[end] ) {
                int middleIndex = ( end - start ) / 2 + start;
                return target <= nums[middleIndex] ?
                        search2(nums, start, middleIndex, target) :
                        search2(nums, middleIndex + 1, end, target);
            } else {
                return -1;
            }
        } else {
            int middleIndex = ( end - start ) / 2 + start;
            int r1 = search2(nums, start, middleIndex, target);
            int r2 = search2(nums, middleIndex + 1, end, target);
            return r1 == -1 ? r2 : r1;
        }
    }

    public int search(int[] nums, int target) {
        if ( nums[0] == target ) {
            return 0;
        } else if ( nums[nums.length - 1] == target ) {
            return nums.length - 1;
        }

        int partitionIndex = getPartitionIndex( nums, 0, nums.length - 1 );


        return target < nums[0] ?
                search( nums, partitionIndex + 1, nums.length - 1, target ) :
                search( nums, 0, partitionIndex, target );
    }

    public int search(int[] nums, int startIndex, int endIndex, int target) {
        if ( startIndex > endIndex ) {
            return -1;
        } else if ( startIndex == endIndex ) {
            return target == nums[startIndex] ? startIndex : -1;
        }

        int middleIndex = ( startIndex + endIndex ) / 2;
        if ( nums[middleIndex] < target ) {
            return search( nums, middleIndex + 1, endIndex, target );
        } else if ( nums[middleIndex] == target ) {
            return middleIndex;
        } else {
            return search( nums, startIndex, middleIndex, target );
        }
    }

    private int getPartitionIndex(int[] arr, int startIndex, int endIndex) {
        endIndex = endIndex >= arr.length ? arr.length - 1 : endIndex;
        if ( endIndex - startIndex <= 10 ) {
            int result = startIndex;
            for ( int i = startIndex + 1; i <= endIndex; i ++ ) {
                result = i - 1;
                if ( arr[i] < arr[i - 1] ) {
                    break;
                }
            }

            return result;
        } else {
            int base = 2;
            int nextIndex = startIndex + base;
            while ( nextIndex < endIndex && arr[nextIndex] > arr[startIndex] ) {
                startIndex = nextIndex;
                nextIndex = nextIndex + base;
                base *= 2;
            }

            return getPartitionIndex( arr, startIndex, nextIndex );
        }
    }
}
