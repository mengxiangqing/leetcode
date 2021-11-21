/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[0] < nums[mid]) {//小于就是mid取到了小于num0的右半边，而且mid右边一定是升序的
                //去找target在哪边
                if (target < nums[mid]) {
                    
                }

                
            }
        }
        return -1;
    }
}
// @lc code=end

