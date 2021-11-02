/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        if (nums[i] >= target)
            return i;
        else{
            int high = nums.length - 1;
            int low = 1;
            int mid = low + (high - low) / 2;
            
        }

        return i;
    }
}
// @lc code=end
