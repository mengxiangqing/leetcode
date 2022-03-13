/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        // dp[i]表示 和为i的完全平方数的最少数量
        int[] dp = new int[n + 1];
        // dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;//最坏情况  i个1相加
            for (int j = 1; i-j*j>=0 ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }


}
// @lc code=end
