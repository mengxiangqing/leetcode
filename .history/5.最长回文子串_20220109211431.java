/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int len = s.length();
        if (len < 2)
            return s;
        int maxLen = 1;
        int begin = 0;
        // dp表示i---j是否是回文串
        boolean[][] dp = new boolean[len][len];
        //所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        
        return result;

    }
}
// @lc code=end
