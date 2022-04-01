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
        // 以nums[i] 结尾的最大连续子串和
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        return dp[nums.length-1];
    }
}
// @lc code=end
