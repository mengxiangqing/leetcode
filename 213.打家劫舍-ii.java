/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            int max = 0;
            for (int i : nums) {
                max = Math.max(max, i);
            }
            return max;
        }
        int n=nums.length;

        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));


    }
    // 如果不偷窃最后一间房屋，则偷窃房屋的下标范围是 [0, n-2][0,n−2]；如果不偷窃第一间房屋，则偷窃房屋的下标范围是 [1, n-1][1,n−1]
    public int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);

        for (int i = start+2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;

        }
        return second;
    }
}
// @lc code=end

