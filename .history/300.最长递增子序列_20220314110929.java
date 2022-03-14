/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        // dp[i] 表示以nums[i]结尾的严格递增子序列的长度
        int[] dp = new int[len + 1];
        dp[0] = 1;
        //往前找到第一个比当前数小的
        for (int i = 1; i < len+1; i++) {
            dp[i]=1;
            for (int j = i-1; j >=0; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                    break;
                }
            }
        }
        return max;
    }
}
// @lc code=end

