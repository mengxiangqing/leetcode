import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solutio {
    private int[] num = new int[10];
    private boolean[] isUsed = new boolean[10];

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i = 0; i < isUsed.length; i++) {
            num[i] = i;
            isUsed[i] = false;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(res, path, k,n);

        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> path, int k, int n) {
        if (path.size() == k) {
            int count = 0;
            for (Integer i : path) {
                count += i;
            }
            if (count == n)
                res.add(path);
            return;
        }
        for (int i = 1; i < num.length; i++) {
            if (isUsed[i] == false) {
                path.add(i);
                isUsed[i] = true;
                backTrack(res, path, k, n);
                path.remove(path.size() - 1);
                isUsed[i] = false;
            }
        }
    }
}
// @lc code=end

