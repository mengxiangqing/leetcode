/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int[] maxF = new int[n];
        int[] minF = new int[n];
        System.arraycopy(nums, 0, maxF, 0, n);
        System.arraycopy(nums, 0, minF, 0, n);
        for (int i = 1; i < n; i++) {
            maxF=Math.max(maxF[i-1]*nums[i],nums[i]);

        }
        return max;
    }
}
// @lc code=end
