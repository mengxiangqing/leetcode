/*
 * @lc app=leetcode.cn id=905 lang=java
 *
 * [905] 按奇偶排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int n = nums.length;
        // right 指向第一个奇数
        int right = n;

        while (left < right) {
            while (left < n && nums[left] % 2 == 1)
                left++;
            while (right > 0 && nums[right] % 2 == 0)
                right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;

    }
}
// @lc code=end
