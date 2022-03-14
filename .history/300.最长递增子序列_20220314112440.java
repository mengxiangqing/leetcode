/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solutio {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        // dp[i] 表示以nums[i]结尾的严格递增子序列的长度
        int[] dp = new int[len + 1];
        dp[0] = 1;
        int[] num1 = new int[len + 1];
        System.arraycopy(nums, 0, num1, 0, len);
        num1[len] = -1;

        // 往前找到比当前数小的最大的那一个
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            // 记录nums[j]最大的那个下标
            int temp = len;
            for (int j = i - 1; j >= 0; j--) {
                if(num1[j]<num1[i]){
                    temp = num1[temp] > num1[j] ? temp : j;
                }

            }
            dp[i] = dp[temp] + 1;
            max = Math.max(max, dp[i]);
            break;
        }
        return max;
    }
}
// @lc code=end
