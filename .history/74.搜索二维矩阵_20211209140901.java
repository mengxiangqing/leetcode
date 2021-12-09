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
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == target)
                    return true;
            }
            return false;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == target)
                    return true;
            }
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            
        }
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
        if (flag_col) {
            low = 0;
            high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix[col][mid] == target) {
                    return true;
                }
                else if (matrix[col][mid] > target) {
                    high = mid - 1;
                }else if(matrix[col][mid]<target){
                    low = mid + 1;
                }
            }
        }
        return false;
    }
}
// @lc code=end
