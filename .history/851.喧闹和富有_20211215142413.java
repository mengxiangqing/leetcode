import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=851 lang=java
 *
 * [851] 喧闹和富有
 */

// @lc code=start
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int dian = quiet.length;
        List<Integer>[] graph = new List[dian];
        for (int i = 0; i < dian; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] bianL : richer) {
            graph[bianL[1]].add(bianL[0]);
        }

        int[] res = new int[dian];
        Arrays.fill(res, -1);
        for (int i = 0; i < dian; i++) {
            dfs(graph, i, quiet, res);
        }

        return res;
    }

    private void dfs(List<Integer>[] graph, int i, int[] quiet, int[] res) {
        if (res[i] != -1)
            return;
        res[i] = i;
        for (int j : graph[i]) {
            
        }
    }
}
// @lc code=end
