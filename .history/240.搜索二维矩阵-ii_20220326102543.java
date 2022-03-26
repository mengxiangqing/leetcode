/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 每一行进行二分查找
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (matrix[i][0] <= target && search(matrix[i], target))
                return true;
        }
        return false;
    }

    public boolean search(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (num[mid] == target) {
                return true;
            } else if (num[mid] > target) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return false;
    }
}
// @lc code=end
