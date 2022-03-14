/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if (len == 1)
            return 1;
        int max = Integer.MIN_VALUE;
        // dp[i] 表示以nums[i]结尾的严格递增子序列的长度
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[len] = -1;

        // 往前找到比当前数小的最大的那一个
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            // 记录dp[j]最大的那个下标
            int temp = len;
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    temp = dp[temp] > dp[j] ? temp : j;
                    flag = true;
                }

            }
            if (flag)
                dp[i] = dp[temp] + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
// @lc code=end
