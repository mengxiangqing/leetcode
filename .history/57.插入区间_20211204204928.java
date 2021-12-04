import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int new1 = newInterval[0];
        int new2 = newInterval[1];
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
                res.add(new int[] { intervals[i][0], intervals[i][1] });
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end
