import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : res) {
                List<Integer> newSubset = new ArrayList<Integer>(subset);
                newSubset.add(nums[i]);
                newSubsets.add(newSubset);
            }
            res.addAll(newSubsets);
            
        }
        return res;
    }
}
// @lc code=end

