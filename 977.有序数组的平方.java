/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {

  public int[] sortedSquares(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int[] result = new int[nums.length];
    int index = nums.length - 1;
    while (index >= 0) {
      if (nums[left] * nums[left] >= nums[right] * nums[right]) {
        result[index] = nums[left] * nums[left];
        left++;
      } else {
        result[index] = nums[right] * nums[right];
        right--;
      }
      index--;
    }
    return result;
  }
}
// @lc code=end
