/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        //溢出
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }


        return 0;
    }
}
// @lc code=end

