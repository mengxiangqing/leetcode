/*
 * @lc app=leetcode.cn id=801 lang=java
 *
 * [801] 使序列递增的最小交换次数
 */

// @lc code=start
class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int count = 0;
        
        return count;

    }

    /**
     * 判断数组nums是否是严格递增
     * 
     * @return 严格递增返回-1，否则返回第一个不递增的下标
     */
    public int isAsc(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end
