/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class 搜索插入位置 {
    public static int searchInsert(int[] nums, int target) {
        int i = nums.length;
        if (nums[0] >= target)
            i = 0;
        else {
            int high = nums.length - 1;
            int low = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target)
                    i = mid;
                else if (nums[mid] < target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }

        return i;
    }
    public static void main(String[] args) {
        int nums[] = { -1, 0, 3, 5, 9, 12 };
        int target = 13;
        System.out.println(searchInsert(nums, target));

    }
}
// @lc code=end
