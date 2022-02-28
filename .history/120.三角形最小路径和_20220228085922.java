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

        dfs(path, triangle, 0);

        return min;
    }

    private void dfs(List<Integer> path, List<List<Integer>> triangle, int curH) {
        if (curH == triangle.size()) {
            int count = 0;
            for (int num : path) {
                count += num;
            }
            min = Math.min(min, count);
            return;
        }
        for (int i = curH; i < triangle.get(curH).size(); i++) {
            
        }
    }
}
// @lc code=end
