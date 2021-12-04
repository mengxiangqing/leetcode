import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] == e2[0])
                    return e1[1] - e2[1];
                return e1[0] - e2[0]; // e1[0]-e2[0]表示对于第一列元素进行升序排序
            }
        });
        for (int i = 0; i < n; i++) {
            int left = arr[i][0];
            int right = arr[i][1];
            if (res.get(res.size() - 1)[1] < left || res.size() == 0) {
                res.add(new int[] { left, right });
            } else {
                // 更新右边界
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], arr[i][1]);

            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end
