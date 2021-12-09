/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solutio {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 先判断在哪一行
        int m = matrix.length;
        int n = matrix[0].length;
        //只有一行
        if (m == 1) {
            if (bin(matrix[0], target))
                return true;
            else
                return false;
        }
        //只有一列
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == target)
                    return true;
            }
            return false;
        }
        //
        if (bin(matrix[m - 1], target))
            return true;
        else {

            int low = 0;
            int high = m - 1;
            int col = 0;
            boolean flag_col = false;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix[mid][0] <= target && matrix[mid + 1][0] > target) {
                    col = mid;
                    flag_col = true;
                    break;
                } else if (matrix[mid][0] > target) {
                    high = mid - 1;
                } else if (matrix[mid][0] < target && matrix[mid + 1][0] < target) {
                    low = mid + 1;
                }
            }
            if (bin(matrix[col], target))
                return true;
        }
        return false;
    }

    public static boolean bin(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
// @lc code=end
