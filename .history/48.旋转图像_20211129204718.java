/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// class Solution {
//     public void rotate(int[][] matrix) {
//         if (matrix.length == 1) {
//             return;
//         }
//         int n = matrix[0].length;
//         for (int i = 0; i < n / 2; i++) {
//             int bian = n - 2 * i;// 边长
//             int zhou = bian * 2 + (bian - 2) * 2;// 周长
//             int[] arr = new int[zhou];
//             int move = bian - 1;// 移动距离

//             // 取四条边
//             int k = 0;
//             for (int j = i; j < n - i; j++) {
//                 arr[k] = matrix[i][j];
//                 k++;
//             }
//             for (int j = i + 1; j < n - i - 1; j++) {
//                 arr[k] = matrix[j][n - i - 1];
//                 k++;
//             }
//             for (int j = n - i - 1; j >= i; j--) {
//                 arr[k] = matrix[n - i - 1][j];
//                 k++;
//             }
//             for (int j = n - i - 2; j > i; j--) {
//                 arr[k] = matrix[j][i];
//                 k++;
//             }

//             // 循环移动数组元素
//             circleMove(arr, move);

//             //放回去
//             k = 0;
//             for (int j = i; j < n - i; j++) {
//                 matrix[i][j] = arr[k];
//                 k++;
//             }
//             // matrix[j][n-i-1]
//             for (int j = i + 1; j < n - i - 1; j++) {
//                 matrix[j][n - i - 1] = arr[k];
//                 k++;
//             }
//             for (int j = n - i - 1; j >= i; j--) {
//                 matrix[n - i - 1][j] = arr[k];
//                 k++;
//             }
//             for (int j = n - i - 2; j > i; j--) {
//                 matrix[j][i] = arr[k];
//                 k++;
//             }

//         }
//     }
//     //循环移动函数
//     private void circleMove(int[] arr, int m) {
//         int n = arr.length;
//         reverseArr(arr, 0, n - m - 1);
//         reverseArr(arr, n - m, n - 1);
//         reverseArr(arr, 0, n - 1);
//     }
//     //翻转数组函数
//     private void reverseArr(int[] arr, int i, int j) {
//         while (i < j) {
//             int temp = arr[i];
//             arr[i] = arr[j];
//             arr[j] = temp;
//             i++;
//             j--;
//         }
//     }
// }

/**
 * 48.旋转图像
 */
// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix[0].length == 1 || matrix[0].length == 0) {
            return;
        }
        int n = matrix[0].length;
        for (int i = 0; i < n/2; i++) {
            //循环变换
            for (int j = i; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[i][n-i-1]=matrix[][n-i];
            }
        }
        
    }

}

// @lc code=end
