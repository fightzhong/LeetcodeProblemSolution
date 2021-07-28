package com.fightzhong.question_51_to_100;

import java.util.Arrays;

public class lc_0073_SetMatrixZeroes {
    /**
     * 时间复杂度 O(MN)
     * 空间复杂度O(1)
     */
    public void setZeroes2(int[][] matrix) {
        boolean colZero = false;
        boolean rowZero = false;
        for ( int i = 0; i < matrix.length; i ++ ) {
            if ( matrix[i][0] == 0 ) {
                colZero = true;
                break;
            }
        }

        for ( int i = 0; i < matrix[0].length; i ++ ) {
            if ( matrix[0][i] == 0 ) {
                rowZero = true;
                break;
            }
        }

        for ( int i = 1; i < matrix.length; i ++ ) {
            for ( int j = 1; j < matrix[0].length; j ++ ) {
                if ( matrix[i][j] == 0 ) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for ( int i = 1; i < matrix.length; i ++ ) {
            for ( int j = 1; j < matrix[0].length; j ++ ) {
                if ( matrix[i][0] == 0 || matrix[0][j] == 0 ) {
                    matrix[i][j] = 0;
                }
            }
        }

        if ( rowZero ) {
            Arrays.fill(matrix[0], 0);
        }

        if ( colZero ) {
            for ( int i = 0; i < matrix.length; i ++ ) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * 时间复杂度 O(MN)
     * 空间复杂度O(Max(M, N))
     */
    public void setZeroes(int[][] matrix) {
        // 0表示该行该列均不用变0, 1表示该行需要变0, 2表示该列需要变0, 3表示该行该列均需要变0
        int[] data = new int[Math.max(matrix.length, matrix[0].length)];
        for (int i = 0; i < matrix.length; i ++) {
            for ( int j = 0; j < matrix[0].length; j ++ ) {
                if ( matrix[i][j] == 0 ) {
                    // 处理行
                    if ( data[i] != 3 ) {
                        data[i] = data[i] == 2 ? 3 : 1;
                    }

                    // 处理列
                    if ( data[j] != 3 ) {
                        data[j] = data[j] == 1 ? 3 : 2;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i ++) {
            for ( int j = 0; j < matrix[0].length; j ++ ) {
                if ( data[i] == 1 || data[j] == 2 || data[i] == 3 || data[j] == 3 ) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
