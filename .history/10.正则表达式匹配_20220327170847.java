/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int s_len = s.length();
        int p_len = p.length();
        if (p_len < s_len && !p.contains("*"))
            return false;
        // 动态规划，dp[i][j]代表s[i] p[j]之前的是否匹配
        boolean[][] dp = new boolean[s_len + 1][p_len + 1];
        dp[0][0] = true;//边界条件，两个空字符串是可以匹配的
        for (int i = 0; i <= s_len; i++) {
            for (int j = 1; j <= p_len; j++) {

            }
        }

        return dp[s_len][p_len];
    }
}
// @lc code=end
