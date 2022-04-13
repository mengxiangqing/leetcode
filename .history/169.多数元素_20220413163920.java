import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int votes = 0;
        int x = nums[0];
        for (int num : nums) {
            if (votes == 0)
                x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
// @lc code=end
