import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        if (isMax(nums)) {
            Arrays.sort(nums);
        } else {
            int temp = nums.length - 1;
            boolean isChange = false;
            int right = nums.length - 1;
            while (!isChange && right > 0) {
                for (int i = right - 1; i >=0; i--) {
                    if (nums[i] < nums[right]) {
                        temp = nums[right];
                        nums[right] = nums[i];
                        nums[i] = temp;
                        isChange = true;
                        temp = i;
                        break;
                    }
                }
                right--;
            }
            Arrays.sort(nums, temp, nums.length - 1);
        }
    }

    boolean isMax(int[] nums) {// 判断是不是降序，也就是最大值
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                return false;
        }
        return true;
    }
}
// @lc code=end
