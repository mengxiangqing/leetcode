/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // int n = nums.length;
        // int[] maxF = new int[n];
        // int[] minF = new int[n];
        // System.arraycopy(nums, 0, maxF, 0, n);
        // System.arraycopy(nums, 0, minF, 0, n);
        // int max = Math.max(Integer.MIN_VALUE, maxF[0]);
        // for (int i = 1; i < n; i++) {
        //     maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(minF[i - 1] * nums[i], nums[i]));
        //     minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(maxF[i - 1] * nums[i], nums[i]));
        //     max = Math.max(max, maxF[i]);

        // }
        // return max;
        int n = nums.length;
        int maxF = nums[0];
        int minF = nums[0];
        int max = Math.max(Integer.MIN_VALUE, maxF);
        for (int i = 1; i < n; i++) {
            int mx = maxF;
            int mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            max = Math.max(max, maxF);

        }
        return max;
    }
}
// @lc code=end
