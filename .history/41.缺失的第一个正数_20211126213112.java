/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int min = 1;
        // int l = 0;
        // int r = nums.length - 1;
        // while (l <= r) {

        // }
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <=n && nums[i] != i + 1&&nums[i]>0) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            
            System.out.println(nums[i]);
        }
        return min;
    }
}
// @lc code=end

