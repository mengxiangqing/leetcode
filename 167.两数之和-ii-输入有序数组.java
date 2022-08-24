/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution{
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};


    }

    /**
     * 在数组的指定闭区间内执行二分查找
     *
     * @param num
     * @param left
     * @param right
     * @param target
     * @return 下标，没找到返回-1
     */
    public int binarySearch(int[] numbers, int low, int high, int target) {

        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
// @lc code=end
