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

            // 设定一个规则，保证在填第 i 个数的时候重复数字只会被填入一次即可。而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」if (i > 0 && nums[i] == nums[i - 1] && visted[i - 1] == 0)
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

