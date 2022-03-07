/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solutio {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(Math.max(j * (i - j), j * dp[i - j]), curMax);

            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
// @lc code=end
