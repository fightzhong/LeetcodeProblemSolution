package com.fightzhong.question_1_to_50;

public class lc_0037_SudokuSolver {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][][] data = new boolean[3][3][10];
        initArr(board, row, col, data);

        solveSudoku(board, 0, 0, row, col, data);
    }

    private boolean solveSudoku(char[][] board, int x, int y, boolean[][] row,
                                boolean[][] col, boolean[][][] data) {
        if ( x == 9 ) {
            return true;
        }

        int nextX = y == 8 ? x + 1 : x;
        int nextY = y == 8 ? 0 : y + 1;

        char c = board[x][y];
        if (c == '.') {
            for (int i = 1; i <= 9; i ++) {
                if (row[x][i] || col[y][i] || data[x / 3][y / 3][i]) {
                    continue;
                } else {
                    row[x][i] = true;
                    col[y][i] = true;
                    data[x / 3][y / 3][i] = true;
                    boolean result = solveSudoku(board, nextX, nextY, row, col, data);
                    if ( result ) {
                        board[x][y] = (char)(i + 48);
                        return true;
                    } else {
                        row[x][i] = false;
                        col[y][i] = false;
                        data[x / 3][y / 3][i] = false;
                    }
                }
            }

            return false;
        } else {
            return solveSudoku(board, nextX, nextY, row, col, data);
        }
    }

    private void initArr(char[][] board, boolean[][] row, boolean[][] col, boolean[][][] data) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                char c = board[i][j];
                if ( c != '.' ) {
                    row[i][c - 48] = true;
                    col[j][c - 48] = true;
                    data[i / 3][j / 3][c - 48] = true;
                }
            }
        }
    }
}
