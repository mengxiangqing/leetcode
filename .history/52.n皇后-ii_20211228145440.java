import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solutio {
    public static int count = 0;

    public int totalNQueens(int n) {
        int[][] a = new int[n][n];
        List<Integer> path = new ArrayList<>();
        backtrack(a,path, 0);
        return count;
    }

    public static void backtrack(int[][] a, List<Integer> path, int start) {
        if (path.size() == a.length) {
            count++;
            return;
        }
        int i = start;
        for (int j = 0; j < a.length; j++) {
            if (isTrue(a, i, j)) {
                a[i][j] = 1;
                path.add(e)
                backtrack(a, path,start + 1);
                a[i][j] = 0;
            }

        }
    }

    private static boolean isTrue(int[][] a, int i, int j) {
        // 检查列
        for (int j2 = 0; j2 < i; j2++) {
            if (a[j2][j] == 1)
                return false;
        }
        // 检查行
        for (int j2 = 0; j2 < j; j2++) {
            if (a[i][j2] == 1)
                return false;
        }
        // 检查左上角
        for (int j2 = j, i2 = i; j2 >= 0 && i2 >= 0; j2--, i2--) {
            if (a[i2][j2] == 1)
                return false;
        }
        // 检查右上角
        for (int j2 = j, i2 = i; j2 < a.length && i2 >= 0; j2++, i2--) {
            if (a[i2][j2] == 1)
                return false;
        }

        return true;
    }
}
// @lc code=end
