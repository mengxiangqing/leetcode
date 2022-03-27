import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        int[] res = new int[n];
        TreeMap<Integer, Integer> set = new TreeMap<>();
        for (int i = 0; i <= res.length-k; i++) {

        }

    }
}
// @lc code=end
