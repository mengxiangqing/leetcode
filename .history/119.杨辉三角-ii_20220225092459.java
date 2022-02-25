import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solutio {
    public List<Integer> getRow(int rowIndex) {

        // 前三行
        List<Integer> pre = new ArrayList<>(Arrays.asList(1));
        if (rowIndex == 0)
            return pre;

        int curIndex = 1;
        while (curIndex++ <= rowIndex) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i <= curIndex; i++) {
                if (i == 0 || i == curIndex)
                    cur.add(1);
                else {
                    cur.add(pre.get(i - 1) + pre.get(i));
                }
            }

            pre = cur;

        }
        return pre;

    }
}
// @lc code=end
