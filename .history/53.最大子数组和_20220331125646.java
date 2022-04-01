import java.util.ArrayList;
import java.util.List;

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
        // 找到第一个大于0的数字
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {

        }

        return max;
    }
}
// @lc code=end
