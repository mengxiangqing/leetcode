import java.util.Arrays;

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
        if (isMax(nums)) {
            Arrays.sort(nums);
        }
        else {
            int temp;
            boolean isChange = false;
            int last = nums[nums.length - 1];
            while (!isChange) {
                for (int i = 0; i < nums.length; i++) {
                    
                }
            }
        }
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

