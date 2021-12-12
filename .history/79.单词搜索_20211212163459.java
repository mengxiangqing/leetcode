/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solutio {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        int[][] used = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == words[0]) {
                    used[i][j] = 1;
                    int l = 1;
                    if (check(board, used, words, l, i, j))
                        return true;
                    else
                        used[i][j] = 0;
                }
            }
        }
        return false;
    }

    // 从words的l位置往下搜索
    private boolean check(char[][] board, int[][] used, char[] words, int l, int i, int j) {
        // 最后一位
        if (l == words.length)
            return true;

        // 上
        if (i - 1 >= 0 && board[i - 1][j] == words[l] && used[i - 1][j] != 1) {
            used[i - 1][j] = 1;
            if (check(board, used, words, l + 1, i - 1, j))
                return true;
            used[i - 1][j] = 0;
        }
        // 下
        if (i + 1 < board.length && board[i + 1][j] == words[l] && used[i + 1][j] != 1) {
            used[i + 1][j] = 1;
            if (check(board, used, words, l + 1, i + 1, j))
                return true;
            used[i + 1][j] = 0;
        }
        // 左
        if (j - 1 >= 0 && board[i][j - 1] == words[l] && used[i][j - 1] != 1) {
            used[i][j - 1] = 1;
            if (check(board, used, words, l + 1, i, j - 1))
                return true;
            used[i][j - 1] = 0;
        }
        // 右
        if (j + 1 < board[0].length && board[i][j + 1] == words[l] && used[i][j + 1] != 1) {
            used[i][j + 1] = 1;
            if (check(board, used, words, l + 1, i, j + 1))
                return true;
            used[i][j + 1] = 0;
        }
        return false;

    }
}
// @lc code=end
