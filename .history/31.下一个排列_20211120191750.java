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
            // 记录
            int r, l;
            while (!isChange && right > 0) {
                for (int i = right - 1; i >= 0; i--) {//找到当前右指针下前面最小的
                    int min = 100000000;
                    if (nums[i] < nums[right]) {
                        r = right;
                        l = i;
                        min = nums[i] < nums[min] ? i : min;
                    }
                }
                right--;
            }
            isChange = true;
            
            temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            Arrays.sort(nums, temp + 1, nums.length);
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
