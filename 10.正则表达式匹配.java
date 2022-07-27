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
        dp[0][0] = true;// 边界条件，两个空字符串是可以匹配的
        // s是空串时，有可能也会匹配，比如p[j]==* 就可以干掉p[j-1]比较p[j-2]
        for (int j = 1; j <= p_len; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= s_len; i++) {
            for (int j = 1; j <= p_len; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j - 2] || dp[i][j - 2] ||
                                dp[i - 1][j]; //这是a*重复多次的情况，去掉s中一个a，p待比较还是a*
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[s_len][p_len];
    }
}
// @lc code=end
