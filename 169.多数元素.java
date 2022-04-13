/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int votes = 0;
        int x = 0;
        //摩尔投票法，x为假定众数，当接下来的数字等于众数就加一，不等加负一
        for (int num : nums) {
            if (votes == 0)
                x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
// @lc code=end
