import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int n=intervals.length;
        while (i < n) {
            int[] temp = new int[2];
            temp[0] = intervals[i][0];
            while (i + 1 < n && intervals[i][1] >= intervals[i + 1][1]) {
                i++;
            }
            temp[1]=
        }


        return (int[][]) res.toArray();
    }
}
// @lc code=end

