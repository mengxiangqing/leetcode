/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    // public int maxProfit(int[] prices) {
    // //遍历一遍
    // int maxP = 0;
    // //记录当前最小值
    // int minP = Integer.MAX_VALUE;
    // for (int i = 0; i < prices.length; i++) {
    // if (prices[i] < minP)
    // minP = prices[i];
    // else if (prices[i] - minP > maxP) {
    // maxP = prices[i] - minP;
    // }
    // }
    // return maxP;
    // }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        if (n == 2) {
            return prices[0] < prices[1] ? prices[1] - prices[0] : 0;
        }
        int[][] dp = new int[2][2];
        // dp[i][0]代表下标为i 这天结束的时候，不持股,手里的现金数
        // dp[i][1]代表下标为i 这天结束的时候，持股，手里的现金数

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);
            dp[i][1] = Math.max(dp[(i - 1) % 2][1], -prices[i]);

        }
        return dp[(n - 1) % 2][0];
    }
}
// @lc code=end
