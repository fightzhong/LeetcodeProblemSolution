package com.fightzhong.question_51_to_100;

public class lc_0074_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = -1;
        for ( int i = 0; i < matrix.length; i ++ ) {
            if ( target >= matrix[i][0] &&
                    target <= matrix[i][matrix[i].length - 1] ) {
                row = i;
                break;
            } else if ( target < matrix[i][0] ) {
                break;
            }
        }

        if ( row == -1 ) {
            return false;
        }

        for ( int i: matrix[row] ) {
            if ( i == target ) {
                return true;
            } else if ( i > target ) {
                break;
            }
        }

        return false;
    }
}
