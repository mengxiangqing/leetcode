import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        // 找到第一个大于0的数字
        for (start = 0; start < nums.length; start++) {
            max = Math.max(nums[start], max);//记录数组中最大值，万一全是负值
            if (nums[start] > 0)
                break;
        }
        if (start == nums.length - 1)
            return max;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < nums.length-1; i++) {
            if (nums[i] + nums[i + 1] >= 0) {

            }
        }

        return max;
    }
}
// @lc code=end
