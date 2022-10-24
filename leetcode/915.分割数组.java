/*
 * @lc app=leetcode.cn id=915 lang=java
 *
 * [915] 分割数组
 */

// @lc code=start
class Solution {
    public int partitionDisjoint(int[] nums) {
        // 逆向生成一个数组
        int[] newNums = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            newNums[i] = min;
        }
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < newNums.length-1; i++) {
            count++;
            max = Math.max(max, nums[i]);
            if(max <= newNums[i+1]){
                return count;
            }
        }
        return count;
    }
}
// @lc code=end
