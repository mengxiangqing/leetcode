import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);

        List<List<Integer>> index = new LinkedList<>();

        return result;

    }
}
// @lc code=end
