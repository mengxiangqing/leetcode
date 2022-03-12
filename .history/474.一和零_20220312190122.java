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
        for (int i = 1; i <=len; i++) {
            int[] count = countZeroAndOne(strs[i - 1]);
            for (int j = 0; j <=m; j++) {
                for (int k = 0; k <= n; k++) {
                    //如果j，k小于当前字符串中的01个数，也就是容量不够，那就只能是dp[i][j][k]=dp[i-1][j][k]
                    //
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zeros = count[0];
                    int ones = count[1];
                    if (j >= zeros && k >= ones) {

                    }
                }
            }
        }

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

