/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                res++;
            n >>= 1;
        }
        return res;
    }
}
// @lc code=end
