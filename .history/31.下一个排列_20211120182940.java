/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        boolean isMax=isMax(nums);
        
    }

    boolean isMax(int[] nums) {//判断是不是降序，也就是最大值
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i + 1])
                return false;
        }
        return true;
    }
}
// @lc code=end

