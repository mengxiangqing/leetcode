import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solutio {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int new1 = newInterval[0];
        int new2 = newInterval[1];
        int location = n;
        // 先根据new1确定在数组的大致位置吧
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] <= new1 && intervals[i][1] >= new1) {
                location = i;
                break;
            }
        }
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (res.size() == 0 || i <= location || res.get(res.size() - 1)[1] < left) {
                if (i == location) {
                    right = Math.max(right, new2);
                }
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
