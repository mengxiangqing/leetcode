/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (!isStr(s.charAt(left)) && left+1 <= right) {
                left++;
            }
            while (!isStr(s.charAt(right)) && left <= right-1) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;

        }
        return true;
    }

    private boolean isStr(char a) {
        if ((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9'))
            return true;
        return false;
    }
}
// @lc code=end
