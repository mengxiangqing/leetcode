import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list = new LinkedList<>();
            find(candidates, target);
            list.add(candidates[i]);
            Collections.sort(list);

        }

        return result;
    }

    public static void find(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int idx) {

        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(list);
            return;
        }
        find(candidates, target - candidates[idx], result, list, idx + 1);
        
        if (target - candidates[idx] >= 0) {
            list.add(candidates[idx]);
            
        }

    }
}
// @lc code=end
