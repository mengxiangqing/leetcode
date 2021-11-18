import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int num = 100000;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum=nums[i] + nums[l] + nums[r];
                if (sum == target)
                    return target;
                if (Math.abs(sum - target) < Math.abs(num - target))
                    num = sum;
                if(sum>target)
                {
                    r--;
                } else
                    l++;
            }

        }
        return num;
    }
}
// @lc code=end

