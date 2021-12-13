/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solutio {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
            int slow = 2, fast = 2;
            while (fast < nums.length) {
                if (nums[slow - 2] != nums[fast]) {
                    nums[slow] = nums[fast];
                    ++slow;
                }
                ++fast;
            }
            return slow;
    }
}
// @lc code=end
