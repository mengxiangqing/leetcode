import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {

  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    //存放 1 2 数组中和出现次数
    Map<Integer, Integer> map = new HashMap<>();
    for (int n1 : nums1) {
      for (int n2 : nums2) {
        map.put(n1 + n2, map.getOrDefault(n1 + n2, 0) + 1);
      }
    }
    int count = 0;
    for (int n3 : nums3) {
      for (int n4 : nums4) {
        count += map.getOrDefault(-(n3 + n4), 0);
      }
    }
    return count;
  }
}
// @lc code=end
