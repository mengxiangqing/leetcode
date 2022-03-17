import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    private int[] num = new int[10];
    private boolean[] isUsed = new boolean[10];

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i = 0; i < isUsed.length; i++) {
            num[i] = i;
            isUsed[i] = false;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(res, path, k, n, 1, 0);

        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> path, int k, int n, int start, int sum) {
        if (path.size() == k && sum == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < num.length && sum +i<=n; i++) {
            if (isUsed[i] == false) {
                path.add(i);
                isUsed[i] = true;
                backTrack(res, path, k, n, i + 1, sum + i);
                path.remove(path.size() - 1);
                isUsed[i] = false;
            }
        }
    }
}
// @lc code=end
