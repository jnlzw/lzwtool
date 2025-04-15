package com.jnlzw.lzwtool.solutions.ac;

import java.util.LinkedList;

public class Solution12 {

    class Pair<I extends Number, I1 extends Number> {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {

        /**
         * M 地雷
         * E 空方块
         * B 已挖出的空方块
         * X 已挖出的地雷
         */

        int[][] visited = new int[board.length][board[0].length];

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(click[0], click[1]));
        visited[click[0]][click[1]] = 1;

        while (!queue.isEmpty()) {

            Pair<Integer, Integer> position = queue.removeFirst();
            int x = position.key;
            int y = position.value;

            // 判断当前位置
            char cur = update(board, x, y);
            if (cur == 'X') {
                break;
            }
            if (cur >= '1' && cur <= '9') {
                continue;
            }

            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (x + i < 0 || x + i >= board.length) {
                        continue;
                    }
                    if (y + j < 0 || y + j >= board[x].length) {
                        continue;
                    }
                    if ((board[x + i][y + j] == 'M' || board[x + i][y + j] == 'E') && visited[x + i][y + j] == 0) {
                        // 未挖出的
                        queue.addLast(new Pair<>(x + i, y + j));
                        visited[x + i][y + j] = 1;
                    }
                }
            }
        }

        return board;
    }

    private char update(char[][] board, int x, int y) {
        char cur = board[x][y];

        if (cur == 'M') {
            board[x][y] = 'X';
        } else if (cur == 'E') {
            Integer num = boomNum(board, x, y);
            if (num == 0) {
                board[x][y] = 'B';
            } else {
                board[x][y] = num.toString().charAt(0);
            }
        }
        return board[x][y];
    }

    private Integer boomNum(char[][] board, int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (x + i < 0 || x + i >= board.length) {
                    continue;
                }
                if (y + j < 0 || y + j >= board[x].length) {
                    continue;
                }
                if (board[x + i][y + j] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }

}