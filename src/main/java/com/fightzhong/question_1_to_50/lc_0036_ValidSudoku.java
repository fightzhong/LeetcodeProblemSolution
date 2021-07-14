package com.fightzhong.question_1_to_50;

public class lc_0036_ValidSudoku {
    public static void main(String[] args) {
        char[][] data = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        data = new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };


        System.out.println( new lc_0036_ValidSudoku().isValidSudoku(data) );
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][][] data = new boolean[3][3][10];
        for (int i = 0; i < 9; i ++) {
            boolean[] row = new boolean[10];
            boolean[] col = new boolean[10];
            for (int j = 0; j < 9; j ++) {
                // 行
                int rowValue = board[i][j];
                if (rowValue != 46 && row[rowValue - 48]) {
                    return false;
                } else if (rowValue != 46) {
                    row[rowValue - 48] = true;
                }

                // 列
                int colValue = board[j][i];
                if (colValue != 46 && col[colValue-48]) {
                    return false;
                } else if (colValue != 46) {
                    col[colValue-48] = true;
                }

                // 3 * 3
                int intValue = board[i][j];
                if ( intValue != 46 && data[i / 3][j / 3][intValue-48] ) {
                    return false;
                } else if ( intValue != 46 ) {
                    data[i / 3][j / 3][intValue-48] = true;
                }
            }
        }

        return true;
    }


}
