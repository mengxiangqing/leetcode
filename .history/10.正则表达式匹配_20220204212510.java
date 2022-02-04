/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int p_len = p.length();
        int s_len = s.length();
        if (p_len < s_len && !p.contains("*"))
            return false;
        //动态规划，dp[i][j]代表s[i] f[j]之前的是否匹配
        boolean[][] dp = new boolean[s_len][p_len];
        //
        return true;
    }
}
// @lc code=end
