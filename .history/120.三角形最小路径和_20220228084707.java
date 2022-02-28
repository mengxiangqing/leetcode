import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int count = 0;
        List<Integer> path = new ArrayList<>();

        dfs(path, triangle, 0);

        return count;
    }

    private void dfs(List<Integer> path, List<List<Integer>> triangle, int curH) {
        if (curH == triangle.size()) {

        }
    }
}
// @lc code=end
