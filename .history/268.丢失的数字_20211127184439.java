/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class S {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean have0 = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                have0 = true;
                break;
            }
        }
        if (have0) {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                while (num <= n && num > 0&& num!=i+1) {
                    nums[i] = nums[num - 1];
                    nums[num - 1] = num;
                    num = nums[i];
                }
            }
        } else
            return 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1)
                return i + 1;
        }
        return n;
    }
}
// @lc code=end
