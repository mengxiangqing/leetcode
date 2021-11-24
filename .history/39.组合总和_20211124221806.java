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
        

        return result;
    }

    public static void find(int[] candidates, int target, List<List<Integer>> result, List<Integer> list) {
        

        if (target == 0) {
            Collections.sort(list);
            if (!result.contains(list)) {
                result.add(new LinkedList<>(list));//因为是引用传递，所以新建列表添加，而不是直接add（list）
            }
            return;
        }
        find(candidates, target - candidates[idx], result, list, idx + 1);
        
        if (target - candidates[idx] >= 0) {
            list.add(candidates[idx]);

        }

    }
}
// @lc code=end
