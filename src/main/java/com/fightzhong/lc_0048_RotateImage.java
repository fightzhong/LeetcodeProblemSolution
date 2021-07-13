package com.fightzhong;

public class lc_0048_RotateImage {
    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        new lc_0048_RotateImage().rotate( data );
    }

    public void rotate(int[][] matrix) {
        int[] leftTop = {0, 0};
        int[] rightTop = {0, matrix.length - 1};
        int[] rightDown = {matrix.length - 1, matrix.length - 1};
        int[] leftDown = {matrix.length - 1, 0};

        int sideLength = matrix.length;
        while ( leftTop[0] < rightDown[0] ) {
            for ( int i = 0; i < sideLength - 1; i ++ ) {
                int curValue = matrix[leftTop[0]][leftTop[1] + i];
                int cacheValue = matrix[rightTop[0] + i][rightTop[1]];
                matrix[rightTop[0] + i][rightTop[1]] = curValue;

                curValue = cacheValue;
                cacheValue = matrix[rightDown[0]][rightDown[1] - i];
                matrix[rightDown[0]][rightDown[1] - i] = curValue;

                curValue = cacheValue;
                cacheValue = matrix[leftDown[0] - i][leftDown[1]];
                matrix[leftDown[0] - i][leftDown[1]] = curValue;

                curValue = cacheValue;
                matrix[leftTop[0]][leftTop[1] + i] = curValue;
            }

            leftTop = new int[]{leftTop[0] + 1, leftTop[1] + 1};
            rightTop = new int[]{rightTop[0] + 1, rightTop[1] - 1};
            rightDown = new int[]{rightDown[0] - 1, rightDown[1] - 1};
            leftDown = new int[]{leftDown[0] - 1, leftDown[1] + 1};
            sideLength -= 2;
        }
    }
}
