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
    public int[][] insert1(int[][] intervals, int[] newInterval) {

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
        res.clear();
        for (int i = 0; i < arr.length; i++) {
            int left = arr[i][0];
            int right = arr[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
                res.add(new int[] { left, right });
            } else {
                // 更新右边界
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], arr[i][1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    //官方题解
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                //在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[] { left, right });
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                //在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                //有交集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[] { left, right });
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}
// @lc code=end
