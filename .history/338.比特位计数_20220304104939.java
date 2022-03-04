/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solutio {
    public int[] countBits(int n) {
        int[] nums = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            nums[i] = Integer.bitCount(i);

        }
        return nums;
    }
}
// @lc code=end

