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
        for (int i = 0; i < n; i++) {
            int sum = 1;
            for (int j = i; j < n; j++) {
                sum *= nums[j];
                max = Math.max(sum, max);

            }
        }
        return max;
    }
}
// @lc code=end
