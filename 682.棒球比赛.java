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
                count -= points.get(points.size() - 1);
                points.remove(points.size() - 1);

            } else if (op.equals("D")) {
                count += points.get(points.size() - 1) * 2;
                points.add(points.get(points.size() - 1) * 2);
            } else if (op.equals("+")) {
                count += points.get(points.size() - 1) + points.get(points.size() - 2);
                points.add(points.get(points.size() - 1) + points.get(points.size() - 2));
            } else {
                count += Integer.parseInt(op);
                points.add(Integer.parseInt(op));

            }
        }

        return count;
    }
}
// @lc code=end

