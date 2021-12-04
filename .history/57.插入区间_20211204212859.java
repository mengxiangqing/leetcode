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
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        if (n == 0) {
            res.add(new int[] { newInterval[0], newInterval[1] });
            return res.toArray(new int[res.size()][]);
        }
        int new1 = newInterval[0];
        int new2 = newInterval[1];
        int location = n;
        if (new1 < intervals[0][0])
            location = 0;
        // 先根据new1确定在数组的大致位置吧
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] <= new1 && intervals[i][1] >= new1) {
                location = i;
                break;
            } else if (intervals[i][0] <= new1 && intervals[i + 1][0] >= new1 && i + 1 < n) {
                location = i + 1;
                break;
            }
        }
        if (location < n && (location >= 0 && new1 >= intervals[0][0])) {

            for (int i = 0; i < n; i++) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                if (res.size() == 0 || i <= location || res.get(res.size() - 1)[1] < left) {
                    if (i == location) {
                        left = Math.min(left, new1);
                        right = Math.max(right, new2);
                    }
                    res.add(new int[] { left, right });
                } else {
                    // 更新右边界
                    res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);

                }
            }
        } else if (location == 0 && new1 < intervals[0][0]) {
            res.add(new int[] { newInterval[0], newInterval[1] });
            for (int i = 0; i < n; i++) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                if (res.get(res.size() - 1)[1] < left) {
                    res.add(new int[] { left, right });
                } else {
                    // 更新右边界
                    res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);

                }
            }
        } else {// 在最后
            for (int i = 0; i < n; i++) {
                res.add(new int[] { intervals[i][0], intervals[i][1] });
            }
            res.add(new int[] { newInterval[0], newInterval[1] });
        }

        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end
