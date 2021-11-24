import java.util.Arrays;
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
            list.add(candidates[i]);

        }






        return result;
    }
}
// @lc code=end

