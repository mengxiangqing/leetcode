import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return lists;
    }

    void dfs(int[] nums, int target, int k) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = k; i < nums.length; i++) {
            // if (target - nums[i] < 0)
            //     break;
            if (i > k && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, target - nums[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end
