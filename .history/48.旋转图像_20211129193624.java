/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solutio {
    public void rotate(int[][] matrix) {
        if (matrix.length == 1) {
            return;
        }
        int n = matrix[0].length;
        for (int i = 0; i < n / 2; i++) {
            int start = matrix[i][i];// 左上角顶点
            int bian = n - 2 * i;// 边长
            int zhou = bian * 2 + (bian - 2) * 2;// 周长
            int[] arr = new int[zhou];
            int move = bian - 1;// 移动距离
            //取四条边
            for (int j = i; j < n - i; j++) {
                arr[j] = matrix[i][j];
            }
            for (int j = i;j<n-i ; j++) {
                arr[j] = matrix[j][n-i];
            }

        }
    }
}
// @lc code=end
