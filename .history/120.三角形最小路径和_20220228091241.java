import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solutio {
    public int min;

    public int minimumTotal(List<List<Integer>> triangle) {
        min = Integer.MAX_VALUE;
        List<Integer> path = new ArrayList<>();

        dfs(path, triangle, 0);

        return min;
    }

    private void dfs(List<Integer> path, List<List<Integer>> triangle, int curH) {
        if (curH == triangle.size()-1) {
            int count = 0;
            for (int num : path) {
                count += num;
            }
            min = Math.min(min, count);
            return;
        }
        for (int i = curH; i < triangle.get(curH).size(); i++) {
            if (curH == 0) {
                path.add(triangle.get(curH).get(i));
                dfs(path, triangle, curH+1);
            } else {

                if (triangle.get(curH - 1).get(i) == path.get(path.size() - 1) ||
                        triangle.get(curH - 1).get(i - 1) == path.get(path.size() - 1)) {
                    path.add(triangle.get(curH).get(i));
                    dfs(path, triangle, curH+1);
                    path.remove(triangle.get(curH).get(i));
                }
            }
        }
    }
}
// @lc code=end
