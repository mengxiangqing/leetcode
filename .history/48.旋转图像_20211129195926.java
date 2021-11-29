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
            // 取四条边
            int k = 0;
            for (int j = i; j < n - i; j++) {
                arr[k] = matrix[i][j];
                k++;
            }
            // matrix[j][n-i-1]
            for (int j = i + 1; j < n - i - 1; j++) {
                arr[k] = matrix[j][n - i - 1];
                k++;
            }
            for (int j = n - i - 1; j >= i; j--) {
                arr[k] = matrix[n - i - 1][j];
                k++;
            }
            for (int j = n - i - 2; j > i; j--) {
                arr[k] = matrix[j][i];
                k++;
            }
            circleMove(arr, move);
            for (int j = 0; j < arr.length; j++) {
                
            }

        }
    }

    private void circleMove(int[] arr, int m) {
        int n = arr.length;
        reverseArr(arr, 0, n - m - 1);
        reverseArr(arr, n - m, n - 1);
        reverseArr(arr, 0, n - 1);
    }

    private void reverseArr(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
// @lc code=end
