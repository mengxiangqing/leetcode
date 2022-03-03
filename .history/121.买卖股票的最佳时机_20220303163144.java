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
            return prices[0] > prices[1] ? prices[0] - prices[1] : 0;
        }
        int[][] dp = new int[n][2];

        return n;
    }
}
// @lc code=end
