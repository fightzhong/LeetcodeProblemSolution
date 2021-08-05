package com.fightzhong.question_51_to_100;

public class lc_0088_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = nums1.length - 1;
        while ( index1 >= 0 ) {
            nums1[index2 --] = nums1[index1 --];
        }

        int insertIndex = 0;
        int nums1Index = nums1.length - m;
        int nums2Index = 0;

        while ( insertIndex < nums1.length ) {
            if ( nums1Index >= nums1.length ) {
                nums1[insertIndex ++] = nums2[nums2Index ++];
            } else if ( nums2Index >= n ) {
                nums1[insertIndex ++] = nums1[nums1Index ++];
            } else {
                if ( nums1[nums1Index] <= nums2[nums2Index] ) {
                    nums1[insertIndex ++] = nums1[nums1Index ++];
                } else {
                    nums1[insertIndex ++] = nums2[nums2Index ++];
                }
            }
        }
    }
}
