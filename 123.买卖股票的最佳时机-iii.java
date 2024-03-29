/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        if (n == 2) {
            return prices[0] > prices[1] ? prices[0] - prices[1] : 0;
        }

        return 0;
    }
}
// @lc code=end
