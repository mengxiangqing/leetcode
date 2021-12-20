import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, path, res);
        return res;

    }
    private static void backtrack(int[] nums,List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, path, res);
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

