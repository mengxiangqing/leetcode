/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int numOf9 = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 9)
                numOf9++;
        }
        if (numOf9 == 0) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        else {
        }
        
        return digits;
    }
}
// @lc code=end

