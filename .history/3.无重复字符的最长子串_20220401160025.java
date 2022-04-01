import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1)
            return n;
        int max = 0;
        // dp[i]表示以i结尾的无重复子串的长度
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {

        }
        return max;
    }
}
// @lc code=end
