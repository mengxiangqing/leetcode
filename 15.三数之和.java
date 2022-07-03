import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {

  /*
     *
     public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
         if (nums.length < 3) {
             return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;// 排过序的，第一个比0大就没必要了
            if (i > 0 && nums[i] == nums[i - 1])
            continue;// 避免重复
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 继续寻找
                    left++;
                    right--;

                    // 跳过重复
                    while (left < right && nums[left] == nums[left - 1])
                    left++;
                    while (left < right && nums[right] == nums[right + 1])
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        return result;

    }
    */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        // 排过序，第一个元素比0大必不可能有合法的
        return res;
      }
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
        // 跳过重复的
      }
      int left = i + 1;
      int right = nums.length - 1;
      while (right > left) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum > 0) {
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          res.add(Arrays.asList(nums[i], nums[left], nums[right]));
          // 去重复逻辑
          while (right > left && nums[right] == nums[right - 1]) right--;
          while (right > left && nums[left] == nums[left + 1]) left++;
          // 找到答案时，双指针同时收缩
          right--;
          left++;
        }
      }
    }
    return res;
  }
}
// @lc code=end
