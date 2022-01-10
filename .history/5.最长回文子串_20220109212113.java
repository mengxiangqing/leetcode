/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
      
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

        //枚举子串长度
        for (int l = 2; l <=len; l++) {
            //枚举左边界
            for (int i = 0; i < len; i++) {
                //由L和i确定右边界,即j-i+1=L
                int j = l + i - 1;
                if (j >= len)
                    break;
                if (charArray[i] != charArray[j])
                    dp[i][j] = false;
                else {
                    if (j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }

            }
        }
        return s.substring(begin, begin + maxLen);

    }
}
// @lc code=end
