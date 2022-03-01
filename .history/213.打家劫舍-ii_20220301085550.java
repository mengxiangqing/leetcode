/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            int max = 0;
            for (int i : nums) {
                max = Math.max(max, i);
            }
            return max;
        }
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(f[0], nums[1]);
        for (int i = 2; i < f.length - 1; i++) {
            f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);

        }

        return f[n - 1];

    }
}
// @lc code=end

