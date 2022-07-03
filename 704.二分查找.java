/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {

  public static int search(int[] nums, int target) {
    // int mid;
    // int low = 0;
    // int high = nums.length-1;
    // while (low <= high) {
    //     mid = (low + high) / 2;
    //     if (nums[mid] == target)
    //         return mid;
    //     else if (nums[mid] > target)
    //         high = mid - 1;
    //     else
    //         low = mid + 1;
    // }
    // return -1;

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
// @lc code=end
