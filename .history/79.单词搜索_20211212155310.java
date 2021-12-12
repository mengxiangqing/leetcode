/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {

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
                    if (check(board, used, words, l))
                        return true;
                }
            }
        }
        return false;
    }
    //从words的l位置往下搜索
    private boolean check(char[][] board, int[][] used, char[] words, int l) {

        return false;

    }
}
// @lc code=end
