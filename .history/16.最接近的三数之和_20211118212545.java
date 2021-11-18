import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int num = target;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > target)
                return nums[i];
                
        }
        return num;
    }
}
// @lc code=end

