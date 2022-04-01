/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        //找到第一个大于0的数字
        for (start = 0; start < nums.length; start++) {
            if (nums[start] > 0)
                break;
            else {
                max = Math.max(nums[start], max);

            }
        }
        return max;
    }
}
// @lc code=end

