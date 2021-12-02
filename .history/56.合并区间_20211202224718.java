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
        
        int n=intervals.length;
        for (int i = 0; i < n; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < left)
                res.add(new int[] { left, right });
            else {
                //更新右边界
                res.get(res.size() - 1)[1] = intervals[i][1];
                }
        }
        

        return  res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

