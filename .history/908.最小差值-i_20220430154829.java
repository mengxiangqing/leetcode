import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */

// @lc code=start
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int avg = (int) Arrays.stream(nums).average().getAsDouble();
        int avg2 = avg + 1;
        int[] nums2 = Arrays.copyOf(nums, nums.length);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > avg) {
                for (int j = 0; j < k; j++) {
                    if (nums[i] > avg)
                        nums[i]--;
                }
            } else if (nums[i] < avg) {
                for (int j = 0; j < k; j++) {
                    if (nums[i] < avg)
                        nums[i]++;
                }
            }
            min = min < nums[i] ? min : nums[i];
            max = nums[i] > max ? nums[i] : max;
        }
        int res = max - min;
        if (res == 0)
            return res;

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] > avg2) {
                for (int j = 0; j < k; j++) {
                    if (nums2[i] > avg2)
                        nums2[i]--;
                }
            } else if (nums2[i] < avg2) {
                for (int j = 0; j < k; j++) {
                    if (nums2[i] < avg2)
                        nums2[i]++;
                }
            }
            min = min < nums2[i] ? min : nums2[i];
            max = nums2[i] > max ? nums2[i] : max;
        }
        return Math.min(res, max - min);

    }
}
// @lc code=end
