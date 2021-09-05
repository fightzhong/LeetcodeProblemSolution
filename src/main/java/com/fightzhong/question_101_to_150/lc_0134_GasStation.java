package com.fightzhong.question_101_to_150;

public class lc_0134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for ( int i = 0; i < gas.length; ) {
            int curGasValue = 0;
            int curIndex = i;
            int nextIndex = ( i + 1 ) % gas.length;
            while ( true ) {
                int canUsedGasValue = curGasValue + gas[curIndex];
                if ( canUsedGasValue < cost[curIndex] ) {
                    // 核心点, 如果i -> curIndex不能走完路程, 那么i + 1 -> curIndex一定也不能走完路程
                    // 因为i 走到 i + 1的时候, 一定是有剩余的油量的, 那么此时是最多油量的, 如果这个时候都不能走完, 后面就更走不完了
                    i = i >= curIndex ? i + 1 : curIndex;
                    break;
                } else if ( nextIndex == i ) {
                    return i;
                }

                curGasValue = canUsedGasValue - cost[curIndex];
                curIndex = nextIndex;
                nextIndex = ( nextIndex + 1 ) % gas.length;
            }
        }

        return -1;
    }

    /*
        public int canCompleteCircuit(int[] gas, int[] cost) {
            for ( int i = 0; i < gas.length; i ++ ) {
                int result = canCompleteCircuit( gas, cost, i, i, ( i + 1 ) % gas.length, 0 );
                if ( result != -1 ) {
                    return result;
                }
            }

            return -1;
        }

        private int canCompleteCircuit(int[] gas, int[] cost, int startIndex, int curIndex, int nextIndex, int curGasValue) {
            int canUsedGasValue = curGasValue + gas[curIndex];
            if ( canUsedGasValue < cost[curIndex] ) {
                return -1;
            } else if ( nextIndex == startIndex ) {
                return startIndex;
            }

            int nextNextIndex = ( nextIndex + 1 ) % gas.length;
            return canCompleteCircuit( gas, cost, startIndex, nextIndex, nextNextIndex, canUsedGasValue - cost[curIndex] );
        }
     */
}
