/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        //f[i]代表以nums[i]结束的非空连续子数组乘积
        int[] f = new int[n];
        int max = Integer.MIN_VALUE;
        f[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] * nums[i], nums[i]);
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
// @lc code=end

