import java.util.ArrayList;
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
        //特殊情况
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
        

        return res;
    }
}
// @lc code=end

