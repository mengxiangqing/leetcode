import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] visted = new int[nums.length];
        List<Integer> path = new ArrayList<>();
        backTrack(nums, res, path, visted);

        return res;

    }

    private void backTrack(int[] nums, List<List<Integer>> res, List<Integer> path, int[] visted) {
        if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visted[i - 1] == 0)
                continue;
            if (visted[i] == 0) {
                visted[i] = 1;
                path.add(nums[i]);
                backTrack(nums, res, path, visted);
                path.remove(path.size() - 1);
                visted[i] = 0;
            }
        }
    }
}
// @lc code=end

