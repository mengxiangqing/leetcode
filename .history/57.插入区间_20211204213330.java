import java.util.ArrayList;
import java.util.Arrays;
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
        if (n == 0) {
            List<int[]> res = new ArrayList<>();
            res.add(new int[] { newInterval[0], newInterval[1] });
            return res.toArray(new int[res.size()][]);
        }
        List<int[]> res = new ArrayList<>(Arrays.asList(intervals));
        res.add(new int[] { newInterval[0], newInterval[1] });
        int[][] arr = res.toArray(new int[res.size()][]);
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (res.get(res.size() - 1)[1] < left || res.size() == 0) {
                res.add(new int[] { left, right });
            } else {
                // 更新右边界
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);

            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end
