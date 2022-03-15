/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == s2.length() && s1.length() == s3.length() && s1.length() == 0)
            return true;
        int n = s1.length();
        int m = s2.length();
        int len = s3.length();
        if (n + m != len)
            return false;
        int
        return false;
    }
}
// @lc code=end
