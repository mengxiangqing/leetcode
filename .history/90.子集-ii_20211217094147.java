import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> empty_List = new ArrayList<>();
        //先加入空集
        res.add(empty_List);
        for (int num : nums) {
            
        }

        return res;

    }
}
// @lc code=end

