/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solutio {
    public boolean isPalindrome(String s) {

        if (s.equals(" ")||s.equals("."))
            return true;
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (!isStr(s.charAt(left)) && left <= right) {
                left++;
            }
            while (!isStr(s.charAt(right)) && left <= right) {
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
