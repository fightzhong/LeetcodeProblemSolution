package com.fightzhong.question_51_to_100;

public class lc_0079_WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for ( int i = 0; i < board.length; i ++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                if ( board[i][j] == word.charAt(0) && exist(board, word, 0, used, i, j) ) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word, int index, boolean[][] used, int x, int y) {
        if ( index == word.length() ) {
            return true;
        } else if ( x < 0 || x >= board.length || y < 0 || y >= board[0].length ) {
            return false;
        } else if ( used[x][y] ) {
            return false;
        } else if ( word.charAt(index) != board[x][y] ) {
            return false;
        }

        used[x][y] = true;

        boolean result = exist(board, word, index + 1, used, x - 1, y) ||
                exist(board, word, index + 1, used, x + 1, y) ||
                exist(board, word, index + 1, used, x, y - 1) ||
                exist(board, word, index + 1, used, x, y + 1);

        used[x][y] = false;

        return result;
    }
}
