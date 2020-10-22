/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package lettcode.搜索算法;

public class P79 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";
        boolean result = solution.exist(board, word);
        System.out.println(result);
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            boolean result = false;
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length; j++){
                    result |= core(board, word, i, j, board.length, board[0].length, 0, visited);
                }
            }
            return result;
        }

        public boolean core(char[][] board, String word, int row, int col, int rows, int cols,
            int index, boolean[][] visited){
            boolean result = false;
            if (row > rows || col > cols || row < 0 || col < 0 || index >= word.length()){
                return result;
            }
            if (board[row][col] == word.charAt(index)){
                visited[row][col] = true;
                if (row < rows - 1 && !visited[row + 1][col] && board[row + 1][col] == word.indexOf(index + 1)){
                    result |= core(board, word,row + 1, col, rows, cols, index + 1, visited);
                }
                if (row > 1 && !visited[row - 1][col] && board[row - 1][col] == word.indexOf(index + 1)){
                    result |= core(board, word,row - 1, col, rows, cols, index + 1, visited);
                }
                if (col < cols - 1 && !visited[row][col + 1] && board[row][col + 1] == word.indexOf(index + 1)){
                    result |= core(board, word,row, col + 1, rows, cols, index + 1, visited);
                }
                if (col > 1 && !visited[row][col - 1] && board[row][col - 1] == word.indexOf(index + 1)){
                    result |= core(board, word,row, col - 1, rows, cols, index + 1, visited);
                }
                visited[row][col] = false;
            }
            return result;
        }

    }

    class Solution2 {
        public boolean exist(char[][] board, String word) {
            int h = board.length, w = board[0].length;
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    boolean flag = check(board, visited, i, j, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
            if (board[i][j] != s.charAt(k)) {
                return false;
            } else if (k == s.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            boolean result = false;
            for (int[] dir : directions) {
                int newi = i + dir[0], newj = j + dir[1];
                if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                    if (!visited[newi][newj]) {
                        boolean flag = check(board, visited, newi, newj, s, k + 1);
                        if (flag) {
                            result = true;
                            break;
                        }
                    }
                }
            }
            visited[i][j] = false;
            return result;
        }
    }

}
