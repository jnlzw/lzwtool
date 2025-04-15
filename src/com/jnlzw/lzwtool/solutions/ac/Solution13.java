package com.jnlzw.lzwtool.solutions.ac;

public class Solution13 {

    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }

                // 向上
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }else if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }else {
                    count++;
                }
            }
        }

        return count;
    }
}
