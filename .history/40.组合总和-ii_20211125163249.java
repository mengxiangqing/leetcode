import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 特殊情况
        if (candidates.length == 0)
            return res;
        if (candidates.length == 1) {
            if (candidates[0] == target) {
                List<Integer> l = new ArrayList<>();
                l.add(candidates[0]);
                res.add(l);
                return res;
            } else
                return res;
        }
        Arrays.sort(candidates);
        int begin = 0;
        int sum = 0;
        List<Integer> path = new ArrayList<>();
        find(candidates, res, target, sum, path, begin);

        return res;
    }

    private void find(int[] candidates, List<List<Integer>> res, int target, int sum, List<Integer> path, int begin) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(path));
        } else {

            for (int i = begin; i < candidates.length; i++) {
                if (i > begin && candidates[i] == candidates[i - 1])
                    continue;
                path.add(candidates[i]);
                find(candidates, res, target, sum + candidates[i], path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

} // @lc code=end
