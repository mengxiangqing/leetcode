/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        boolean hava9 = false;
        //没9直接加一
        for (int i = digits.length-1; i >0 ; i++) {
            if (digits[i] == 9) {
                hava9 = true;
                break;
            }
        }
        if (!hava9) {
            digits[digits.length - 1] += 1;
            return digits;
        } else {
            return digits;
        }

    }
}
// @lc code=end
