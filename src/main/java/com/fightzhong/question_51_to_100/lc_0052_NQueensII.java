package com.fightzhong.question_51_to_100;

public class lc_0052_NQueensII {
    public int totalNQueens(int n) {
        char[][] data = new char[n][n];
        for ( char[] arr: data ) {
            for ( int i = 0; i < n; i ++ ) {
                arr[i] = '.';
            }
        }

        return solveNQueens( data, 0, 0, n );
    }


    private int solveNQueens(char[][] data, int x, int y, int remainQueen) {
        if ( x == data.length ) {
            return remainQueen == 0 ? 1 : 0;
        }


        int nextX = y == data.length - 1 ? x + 1 : x;
        int nextY = y == data.length - 1 ? 0 : y + 1;

        int result = 0;
        if ( canLocationQueen( data, x, y ) ) {
            data[x][y] = 'Q';
            result += solveNQueens( data, nextX, nextY, remainQueen - 1 );
            data[x][y] = '.';
        }

        result += solveNQueens( data, nextX, nextY, remainQueen );

        return result;
    }

    private boolean canLocationQueen(char[][] data, int x, int y) {
        for ( int i = 0; i < data.length; i ++ ) {
            if ( data[x][i] == 'Q' || data[i][y] == 'Q' ) {
                return false;
            }
        }

        int x1 = x;
        int y1 = y;

        int x3 = x;
        int y3 = y;

        while ((x1 >= 0 && y1 >= 0) || (x3 >= 0 && y3 < data.length) ) {
            if ( x1 >= 0 && y1 >= 0 ) {
                if ( data[x1][y1] == 'Q' ) {
                    return false;
                }
                x1 --;
                y1 --;
            }

            if ( x3 >= 0 && y3 < data.length ) {
                if ( data[x3][y3] == 'Q' ) {
                    return false;
                }
                x3 --;
                y3 ++;
            }
        }

        return true;
    }
}
