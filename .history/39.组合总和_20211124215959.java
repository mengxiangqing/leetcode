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

    public static int find(int[] candidates, int target, List<List<Integer>> result, List<Integer> list) {

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == target) {
                return target;
            } else {
                if (candidates[i] > target) {
                    int temp = find(candidates, candidates[i] - target);
                    if (temp != 0) {

                    }
                    return;
                } else
                    return 0;
            }
        }
    }
}
// @lc code=end
