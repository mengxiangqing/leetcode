import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int min;

    public int minimumTotal(List<List<Integer>> triangle) {
        min = Integer.MAX_VALUE;
        int[][] dp = new int[triangle.size()][triangle.get(0).size()];
        dp[0][0] = triangle.get(0).get(0);


        return min;
    }


}
// @lc code=end
