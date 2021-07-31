package com.fightzhong.question_51_to_100;

public class lc_0075_SortColors {
    public static void main(String[] args) {
        new lc_0075_SortColors().sortColors( new int[]{1, 2, 0} );
    }

    public void sortColors(int[] nums) {
        int redIndex = 0;
        int blueIndex = nums.length - 1;
        for ( int i = 0; i < nums.length && i <= blueIndex; i ++ ) {
            int v = nums[i];
            if ( v == 0 ) {
                int temp = nums[redIndex];
                nums[redIndex] = v;
                nums[i] = temp;
                redIndex ++;
            } else if (v == 2) {
                int temp = nums[blueIndex];
                nums[blueIndex] = v;
                nums[i] = temp;
                blueIndex --;
                i --;
            }
        }
    }
}
