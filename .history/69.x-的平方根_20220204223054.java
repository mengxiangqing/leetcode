/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int res = 0;
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                
            }
        }
        return res;
    }
}
// @lc code=end

