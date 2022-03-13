/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {

    }

    private boolean isPow(int n) {
        for (int i = 0; i < n/2; i++) {
            if (Math.pow(i, 2) == n)
                return true;
        }

        return false;
    }
}
// @lc code=end

