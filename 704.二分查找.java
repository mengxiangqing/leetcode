/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public static int search(int[] nums, int target) {
        int mid;
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { -1, 0, 3, 5, 9, 12 };
        int target = 13;
        System.out.println(search(nums, target));

    }
}
// @lc code=end
