/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minP = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minP)
                minP = prices[i];
            else if (prices[i] - minP > maxP) {
                maxP = prices[i] - minP;
            }
        }
        return maxP;
    }
}
// @lc code=end

