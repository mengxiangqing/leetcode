import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=682 lang=java
 *
 * [682] 棒球比赛
 */

// @lc code=start
class Solution {
    public int calPoints(String[] ops) {
        int count = 0;
        List<Integer> points = new ArrayList<>();
        for (String op : ops) {
            if (op.equals("C")) {
                points.remove(points.size() - 1);
            } else if (op.equals("D")) {
                points.add(points.get(points.size() - 1) * 2);
            } else if (op.equals("+")) {
                points.add(points.get(points.size() - 1) + points.get(points.size() - 2));

            } else {
                points.add(Integer.parseInt(op));
            }
        }
        for (Integer integer : points) {
            count += integer;
        }
        return count;
    }
}
// @lc code=end

