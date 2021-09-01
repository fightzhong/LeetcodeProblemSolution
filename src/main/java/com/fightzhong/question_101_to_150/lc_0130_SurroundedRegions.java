package com.fightzhong.question_101_to_150;

public class lc_0130_SurroundedRegions {
    public void solve(char[][] board) {
        handlerLine( 0, board[0], board );
        handlerLine( board.length - 1, board[board.length - 1], board );
        handlerColumn( 0, board );
        handlerColumn( board[0].length - 1, board );

        for ( int i = 0; i < board.length; i ++ ) {
            for ( int j = 0; j < board[i].length; j ++ ) {
                if ( board[i][j] == 'Z' ) {
                    board[i][j] = 'O';
                } else if ( board[i][j] == 'O' ) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void handlerColumn(int y, char[][] board) {
        for ( int i = 0; i < board.length; i ++ ) {
            if ( board[i][y] == 'O' ) {
                solve( board, i, y );
            }
        }
    }

    private void handlerLine(int x, char[] line, char[][] board) {
        for ( int i = 0; i < line.length; i ++ ) {
            if ( line[i] == 'O' ) {
                solve( board, x, i );
            }
        }
    }

    private void solve(char[][] board, int x, int y) {
        if ( x >= board.length || y >= board[0].length || x < 0 || y < 0 || board[x][y] != 'O' ) {
            return;
        }

        board[x][y] = 'Z';
        solve( board, x, y + 1 );
        solve( board, x, y - 1 );
        solve( board, x + 1, y );
        solve( board, x - 1, y );
    }
}
