/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char l = s.charAt(left);

        }
        return true;
    }
    private boolean isStr(char a) {
        if ((a >= 'A' && a <= 'X') || (a >= 'a' && a <= 'z') || (a >= '0' && a <= '9'))
            return true;
        return false;
    }
}
// @lc code=end

