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
        System.out.println(avg);
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
        return max-min;
    }
}
// @lc code=end

