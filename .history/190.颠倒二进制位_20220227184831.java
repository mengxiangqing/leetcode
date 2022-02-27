/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0, j = 31; i < 31; i++, j--) {
            if ((n & 1 << i) != 0) {
                res += 1 << j;
            }
        }
        return res;
    }
}
// @lc code=end
