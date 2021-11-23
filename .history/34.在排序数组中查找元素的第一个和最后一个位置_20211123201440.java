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
        while (l <= r) {//注意等号，要不然两个元素就不动了
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                // 去找前
                boolean isBian = false;
                for (int i = mid; i >= 0; i--) {
                    if (nums[i] != target) {
                        res[0] = i + 1;
                        isBian = true;
                        break;
                    }
                }
                if (!isBian)// 如果没找到不是target的
                    res[0] = 0;
                isBian = false;
                for (int i = mid; i < nums.length; i++) {
                    if (nums[i] != target) {
                        res[1] = i - 1;
                        isBian = true;
                        break;
                    }
                }
                if (!isBian)// 如果没找到不是target的
                    res[1] = nums.length - 1;
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
