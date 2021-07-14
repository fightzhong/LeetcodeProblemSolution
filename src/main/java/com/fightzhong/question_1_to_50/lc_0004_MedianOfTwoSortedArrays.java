package com.fightzhong.question_1_to_50;

public class lc_0004_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        new lc_0004_MedianOfTwoSortedArrays().findMedianSortedArrays( new int[]{}, new int[]{2,3} );
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        int count1 = totalSize % 2 == 0 ? totalSize / 2 : totalSize / 2 + 1;
        int num1Index = 0;
        int num2Index = 0;
        int curCount = 0;
        while ( num1Index < nums1.length || num2Index < nums2.length ) {
            int num1 = Integer.MAX_VALUE;
            if ( num1Index < nums1.length ) {
                num1 = nums1[num1Index];
            }

            int num2 = Integer.MAX_VALUE;
            if ( num2Index < nums2.length ) {
                num2 = nums2[num2Index];
            }

            if ( num1 < num2 ) {
                num1Index ++;
            } else {
                num2Index ++;
            }

            if ( count1 == ++ curCount ) {
                if ( num1 < num2 ) {
                    int v2 = totalSize % 2 == 0 ?
                            ( num1Index >= nums1.length ? nums2[num2Index] : (num2Index >= nums2.length ?
                                    nums1[num1Index] : Math.min( nums1[num1Index], nums2[num2Index] ) ) ) : num1;
                    return ((double)num1 + (double)v2) / 2;
                } else {
                    int v2 = totalSize % 2 == 0 ?
                            ( num1Index >= nums1.length ? nums2[num2Index] : (num2Index >= nums2.length ?
                                    nums1[num1Index] : Math.min( nums1[num1Index], nums2[num2Index] ) ) ) : num2;
                    return ((double)num2 + (double)v2) / 2;
                }
            }
        }

        return 0;
    }
}
