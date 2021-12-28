/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        int count = 0;
        int[][] a = new int[n][n];
        backtrack(a, count, 0);
        return count;
    }

    public static void backtrack(int[][] a, int count, int start) {
        if (start == a.length) {
            count++;
            return;
        }
        for (int i = start; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (isTrue(a,i,j)) {
                    
                }

            }
        }
    }

    private static boolean isTrue(int[][] a, int i, int j) {
        return false;
    }
}
// @lc code=end
