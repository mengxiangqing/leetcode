/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {

  public int removeElement(int[] nums, int val) {
    if (nums.length == 0) return 0;
    int left = 0;
    int right = 0;
    while (right < nums.length) {
      if (nums[right] != val) {
        nums[left] = nums[right];
        left++;
      }
      right++;
    }
    return left;
  }
}
// @lc code=end
