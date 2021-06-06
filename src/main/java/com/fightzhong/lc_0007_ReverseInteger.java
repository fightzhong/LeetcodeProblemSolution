package com.fightzhong;

import java.util.LinkedList;
import java.util.List;

public class lc_0007_ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new lc_0007_ReverseInteger().reverse_1(901000));
    }

    public int reverse_2(int x) {
        if ( x == 0 ) {
            return 0;
        }

        boolean isPositiveNumber = x > 0;
        StringBuilder s = new StringBuilder();
        int targetX = x;
        while ( targetX != 0 ) {
            s.append(Math.abs(targetX % 10));
            targetX = targetX / 10;
        }

        long longResult = Long.parseLong(s.toString());
        longResult = isPositiveNumber ? longResult : longResult * -1;
        return longResult > Integer.MAX_VALUE || longResult < Integer.MIN_VALUE ? 0 : (int) longResult;
    }

    public int reverse_1(int x) {
        boolean isPositiveNumber = x > 0;
        LinkedList<Integer> data = new LinkedList<>();
        int targetX = x;
        while ( targetX != 0 ) {
            data.addLast( Math.abs(targetX % 10) );
            targetX = targetX / 10;
        }

        // 剔除最后几个0
        while ( data.size() > 0 && data.getFirst() == 0 ) {
            data.removeFirst();
        }

        // 开始封装新的值
        int result = 0;
        int base = 1;
        while ( data.size() > 0 ) {
            Integer removeLast = data.removeLast();
            int lastValue = base * removeLast;
            if ( lastValue != 0 && lastValue / removeLast != base ) {
                return 0;
            }

            result = isPositiveNumber ? result + lastValue : result - lastValue;
            if ( (isPositiveNumber && result < 0) ||
                    (!isPositiveNumber && result > 0) ) {
                return 0;
            }

            base *= 10;
        }

        return result;
    }
}

