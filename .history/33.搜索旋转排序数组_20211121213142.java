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
            if (nums[0] < nums[mid]) {//尝试去分割数组
                //去判断mid两边哪边是有序的
                if()

                
            }
        }
        return -1;
    }
}
// @lc code=end

