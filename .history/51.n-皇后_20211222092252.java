import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 * 「NN 皇后问题」研究的是如何将 NN 个皇后放置在 N \times NN×N 的棋盘上，并且使皇后彼此之间不能相互攻击。
皇后的走法是：可以横直斜走，格数不限。因此要求皇后彼此之间不能相互攻击，等价于要求任何两个皇后都不能在同一行、同一列以及同一条斜线上。
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 1) {
            res.add(new ArrayList<>(Arrays.asList("Q")));
            return res;
        }
        String[] b = new String[n];
        for (int i = 0; i < b.length; i++) {
            b[i] = new String;
        }

        List<String> board = new ArrayList<>(Arrays.asList(b));
        backtrack(board, res, 0);
        return res;

    }

    private void backtrack(List<String> board, List<List<String>> res, int row) {
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col))
                continue;
            // 做选择
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());
            // 进入下一行
            backtrack(board, res, row + 1);
            // 撤销选择
            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }

    }

    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        // 检查同列
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }
        // 检测右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        // 检测左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
}
// @lc code=end
