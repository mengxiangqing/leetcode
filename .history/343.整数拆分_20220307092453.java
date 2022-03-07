/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        if (n <= 3)
            return n - 1;
        if (n == 4)
            return 4;
        if (n == 5)
            return 6;

        // 尽可能多的3
        int num3 = n / 3;
        int yu3 = n % 3;
        if (yu3 == 0)
            return (int) Math.pow(3, num3);
        else if (yu3 == 1)
            return (int) Math.pow(3, num3 - 1) * 4;
        else {
            return (int) (Math.pow(3, num3) * 2);
        }
    }
}
// @lc code=end
