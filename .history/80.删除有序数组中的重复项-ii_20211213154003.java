/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solutio {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (flag <= 2 && nums[i] == nums[len]) {
                flag++;
            } else if (nums[i] != nums[len]) {
                len += flag; 
                nums[len] = nums[i];
                flag = 0;
            }
        }
        return len;

    }
}
// @lc code=end
