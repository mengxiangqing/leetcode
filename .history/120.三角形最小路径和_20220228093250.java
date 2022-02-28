import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int min;

    public int minimumTotal(List<List<Integer>> triangle) {
        min = Integer.MAX_VALUE;
        List<Integer> path = new ArrayList<>();

        dfs(path, triangle, 0, 0);

        return min;
    }

    private void dfs(List<Integer> path, List<List<Integer>> triangle, int curH, int lo) {
        if (curH == triangle.size()) {
            int count = 0;
            for (int num : path) {
                count += num;
            }
            min = Math.min(min, count);
            return;
        }
        for (int i = lo; i < lo + 2; i++) {
            if (curH == 0) {
                if (!path.isEmpty()) {
                    break;
                }
                path.add(triangle.get(curH).get(i));
                dfs(path, triangle, curH + 1,i);
            } else {
                    path.add(triangle.get(curH).get(i));
                    dfs(path, triangle, curH + 1,i);
                    path.remove(path.size()-1);
             
            }
        }
    }
}
// @lc code=end
