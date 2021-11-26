/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //归位
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0&&nums[i] <=n && nums[i] != nums[nums[i]-1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
           }
        }
        return n + 1;
    }
}
// @lc code=end

