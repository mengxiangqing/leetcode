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
        return false;

    }
}
// @lc code=end
