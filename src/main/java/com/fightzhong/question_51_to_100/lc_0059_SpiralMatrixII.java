package com.fightzhong.question_51_to_100;

public class lc_0059_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] data = new int[n][n];
        int[] leftTop = {0, 0};
        int[] rightTop = {0, n - 1};
        int[] leftDown = {n - 1, 0};
        int[] rightDown = {n - 1, n - 1};

        int curN = 0;
        int target = n * n;
        while ( target - curN > 1 ) {
            // [leftTop, rightTop}
            for ( int i = leftTop[1]; i < rightTop[1]; i ++ ) {
                data[leftTop[0]][i] =  ++curN;
            }

            // [rightTop, rightDown}
            for ( int i = rightTop[0]; i < rightDown[0]; i ++ ) {
                data[i][rightTop[1]] = ++curN;
            }

            // [rightDown, leftDown}
            for ( int i = rightDown[1]; i > leftDown[1]; i -- ) {
                data[rightDown[0]][i] = ++curN;
            }

            // [leftDown, leftTop}
            for ( int i = leftDown[0]; i > leftTop[0]; i -- ) {
                data[i][leftDown[1]] = ++curN;
            }

            leftTop[0] += 1; leftTop[1] += 1;
            rightTop[0] += 1; rightTop[1] -= 1;
            leftDown[0] -= 1; leftDown[1] += 1;
            rightDown[0] -= 1; rightDown[1] -= 1;
        }

        if ( curN != target ) {
            data[leftTop[0]][leftTop[1]] = ++curN;
        }

        return data;
    }
}
