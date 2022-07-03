/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {

  public int minSubArrayLen(int target, int[] nums) {
    int left = 0;
    int right = 0;
    int curSum = 0;
    int min = nums.length + 1;
    /*
     *
     while (right < nums.length) {
     if (curSum < target) {
         curSum += nums[right];
         right++;
        }
        if (curSum >= target) {
            while (curSum - nums[left] >= target) {
                curSum -= nums[left];
                left++;
            }
            min = Math.min(right - left, min);
            curSum -= nums[left];
            left++;
        }
    }
    */
    for (right = 0; right < nums.length; right++) {
        curSum += nums[right];
        while (curSum >= target) {
            min = Math.min(min, right - left + 1);
            curSum -= nums[left++];
        }
    }
    return min == nums.length + 1 ? 0 : min;
  }
}
// @lc code=end
