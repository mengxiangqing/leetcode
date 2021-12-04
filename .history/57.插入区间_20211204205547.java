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
            if (intervals[i][1] > new1) {
                location = i-1;
                break;
            }
        }
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < new1) {
                res.add(new int[] { left, right });
            } else {

            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end
