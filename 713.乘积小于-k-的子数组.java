/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于 K 的子数组
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int n = nums.length;
        int ans = 0;
        // j为左端点，i为右端点
        for (int i = 0, j = 0, cur = 1; i < n; i++) {
            cur *= nums[i];
            while (cur >= k)
                cur /= nums[j++];
            ans += i - j + 1;
        }
        return ans;
    }

}
// @lc code=end
