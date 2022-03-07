/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return n;
        int mul = 1;
        // 尽可能多的3
        int num3 = n / 3;
        int yu3 = n % 3;

        return (int) Math.pow(3, num3-1)*(yu3+1);
    }
}
// @lc code=end
