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
        for (int i = 0; i <= m/2; i++) {
            for (int j = i; j < n-1-i; j++) {
                res.add(matrix[i][j]);
                
            }
        }
        return res;
    }
}
// @lc code=end

