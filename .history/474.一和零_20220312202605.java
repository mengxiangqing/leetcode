/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // //dp[i][j][k] 表示输入字符串在子区间[0,i]能够使用j个0和k个1的字串串的最大数量
        // int[][][] dp = new int[len + 1][m + 1][n + 1];
        // for (int i = 1; i <= len; i++) {
        // int[] count = countZeroAndOne(strs[i - 1]);
        // for (int j = 0; j <= m; j++) {
        // for (int k = 0; k <= n; k++) {
        // //如果j，k小于当前字符串中的01个数，也就是容量不够，那就只能是dp[i][j][k]=dp[i-1][j][k]
        // //如果容量够，那就有两种选择，一是不选当前字符串，二是选择当前字符串，然后比较哪个子串长
        // dp[i][j][k] = dp[i - 1][j][k];
        // int zeros = count[0];
        // int ones = count[1];
        // if (j >= zeros && k >= ones) {
        // dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);

        // }
        // }
        // }
        // }
        int[][] dp = new int[m][n];
        for (int i = 0; i < len; i++) {
            int[] count = countZeroAndOne(strs[i]);
            int zeros = count[0];
            int ones = count[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones])+1;
                }
            }
        }
        return dp[m][n];

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
