import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> h = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (!h.contains(i)) {
                        h.add(i);
                    }
                    if (!l.contains(j)) {
                        l.add(j);
                    }
                }

            }
        }
        for (int i = 0; i < h.size(); i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[h.get(i)][j] = 0;
            }
        }
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][l.get(i)] = 0;
            }
        }

    }
}
// @lc code=end
