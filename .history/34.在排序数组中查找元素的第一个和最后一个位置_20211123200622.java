/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            if (target == nums[0]) {
                res[0] = 0;
                res[1] = 0;
                return res;
            } else
                return res;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {//
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                //去找前
                int qian = mid;
                while (nums[mid]==nums[qian]&&qian>0) {
                    qian--;
                }
                res[0] = qian==0?qian:qian+1;
                int hou = mid;
                while (nums[mid] == nums[hou] && hou < nums.length - 1) {
                    hou++;
                }
                res[1] =hou==nums.length-1?hou: hou-1;
                break;
            } else if (nums[mid] < target) {
                l++;
            } else
                r--;
        }
        return res;
    }
}
// @lc code=end
