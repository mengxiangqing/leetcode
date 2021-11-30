import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solutio {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        List<Integer> res = new ArrayList<>();
        if (n == 1 && m == 1) {
            res.add(matrix[0][0]);
            return res;
        }
        int heng = n;
        int shu = m;
        for (int i = 0; i <= m / 2; i++) {
            heng = Math.max(n - 2 * i, 1);
            shu = Math.max(m - 2 * i, 1);
            if (shu == 1) {

                // 上边
                for (int j = i; j < n - i; j++) {
                    res.add(matrix[i][j]);
                }
            } else if (heng == 1) {
                for (int j = i + 1; j < m - i; j++) {
                    res.add(matrix[j][i]);

                }
            } else if (shu > 1 && heng > 1) {

                // 上边
                for (int j = i; j < n - i; j++) {
                    res.add(matrix[i][j]);
                }
                // 右边
                for (int j = i + 1; j < m - i - 1; j++) {
                    res.add(matrix[j][n - i - 1]);
                }
                // 下边
                for (int j = n - i - 1; j >= i; j--) {
                    res.add(matrix[m - i - 1][j]);
                }
                // 左边
                for (int j = m - i - 1 - 1; j > i; j--) {
                    res.add(matrix[j][i]);
                }
            }

        }
        return res;
    }
}
// @lc code=end
