package com.fightzhong;

public class lc_0011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while ( left < right ) {
            max = Math.max( max, Math.min(height[right], height[left]) * (right - left) );

            if ( height[left] < height[right] ) {
                left ++;
            } else {
                right --;
            }
        }

        return max;
    }
}
