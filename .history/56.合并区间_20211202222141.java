import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {    // 匿名内部类
            @Override
            public int compare(int[] e1, int[] e2) {
                if (e1[0]==e2[0]) return e1[1]-e2[1];
                return e1[0]-e2[0]; // e1[0]-e2[0]表示对于第一列元素进行升序排序
            }
        });
        
        int i = 0;
        int n=intervals.length;
        while (i < n) {
            int start = intervals[i][0];
            int wei=intervals[i][1];
            while (i + 1 < n && intervals[i][1] >= intervals[i + 1][0]) {
                i++;
            }
            int end = Math.max(intervals[i][1],wei);
            res.add(new int[]{start,end});
            i++;
        }
        

        return  res.toArray(new int[res.size()]);
    }
}
// @lc code=end

