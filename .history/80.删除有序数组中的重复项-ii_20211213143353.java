/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        nums[len++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                nums[len++] = nums[i];
            } else
                continue;
        }
        return len;

    }
}
// @lc code=end

