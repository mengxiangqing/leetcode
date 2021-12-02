import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solutio {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int n=intervals.length;
        while (i < n) {
            int start = intervals[i][0];
            while (i + 1 < n && intervals[i][1] >= intervals[i + 1][0]) {
                i++;
            }
            int end = intervals[i][1];
            res.add(Arrays.asList(start,end));
            i++;
        }


        return (int[][]) res.toArray();
    }
}
// @lc code=end

