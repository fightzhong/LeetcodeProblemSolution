package com.fightzhong.question_1_to_50;

import java.util.LinkedList;
import java.util.Stack;

public class lc_0042_TrappingRainWater {
    public static void main(String[] args) {
        new lc_0042_TrappingRainWater().trap( new int[]{0,1,0,2,1,0,1,3,2,1,2,1} );
    }

    public int trap(int[] height) {
        int total = 0;

        LinkedList<Integer> stack = new LinkedList<>();
        for ( int i: height ) {
            Integer peek;
            if ( stack.size() > 0 && i >= (peek = stack.getFirst()) ) {
                int count = 0;
                int totalAdd = 0;
                while ( stack.size() != 0 ) {
                    totalAdd += stack.removeFirst();
                    count ++;
                }

                int curV = count * peek - totalAdd;
                if ( curV < 0 ) {
                    curV = 0;
                }

                total += curV;

            }
            stack.addLast(i);
        }

        LinkedList<Integer> stack2 = new LinkedList<>();
        if ( stack.size() != 0 ) {
            int i = 1;
            while ( i <= stack.size() ) {
                Integer peek;
                if ( stack2.size() > 0 && height[height.length - i] >= (peek = stack2.getFirst()) ) {
                    int count = 0;
                    int totalAdd = 0;
                    while ( stack2.size() != 0 ) {
                        totalAdd += stack2.removeFirst();
                        count ++;
                    }

                    int curV = count * peek - totalAdd;
                    if ( curV < 0 ) {
                        curV = 0;
                    }

                    total += curV;

                }
                stack2.addLast(height[height.length - i]);
                i++;
            }
        }

        return total;
    }
}
