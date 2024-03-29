import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 特殊情况
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        if (candidates.length == 1) {
            if (target % candidates[0] == 0) {
                List<Integer> l = new ArrayList<>();
                for (int i = 0; i < target / candidates[0]; i++) {
                    l.add(candidates[0]);
                }
                result.add(l);
                return result;
            } else
                return result;
        }
        // Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();// 记录路径
        int sum = 0;// 当前路径和
        find(candidates, target, result, path, sum,0);
        return result;
    }

    // 因为是引用传递，所以往列表里面添加时新建列表添加，而不是直接add（list）
    public static void find(int[] candidates, int target, List<List<Integer>> result, List<Integer> path, int sum,int begin) {
        if (sum > target)
            return;
        if (sum == target) {
            // List<Integer> list = new ArrayList<>(path);
            // Collections.sort(list);
            // if (!result.contains(list)) {
            //     result.add(list);
            // }
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);
            find(candidates, target, result, path, sum + candidates[i],i);
            path.remove(path.size() - 1);
        }
        return;
    }
}
// @lc code=end
