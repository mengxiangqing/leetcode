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
        //dp表示i---j是否是回文串
        boolean[][] dp = new boolean[len][len];
        
        return result;

    }
}
// @lc code=end

