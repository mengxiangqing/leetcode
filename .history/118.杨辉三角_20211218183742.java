import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>() {
            {
                add(1);
            }
        });
        int[] a = new int[] { 1, 1 };

        List<Integer> two = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

        }
        return res;
    }
}
// @lc code=end
