/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        //dp[i][j][k] 表示输入字符串在子区间[0,i]能够使用j个0和k个1的字串串的最大数量
        int[][][] dp = new int[len + 1][m + 1][n + 1];

    }

    private int[] countZeroAndOne(String str) {
        int[] ans = new int[2];
        for (char c : str.toCharArray()) {
            ans[c - '0']++;
        }
        return ans;
    }
}
// @lc code=end

