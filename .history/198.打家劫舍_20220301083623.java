/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0], nums[1]);


        int max = 0;
        int n = nums.length;
        //f[i]代表到i的最大值
        int[] f = new int[n];
        f[0] = nums[0];
        max = f[0] > max ? f[0] : max;
        f[1] = nums[1];
        max = f[1] > max ? f[1] : max;

        return max;
    }
}
// @lc code=end

