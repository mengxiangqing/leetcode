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
            if (nums[i] == nums[len]) {
                if (flag < 2) {
                    
                }
                flag++;
                len++;
            }
        }
        return len;

    }
}
// @lc code=end
