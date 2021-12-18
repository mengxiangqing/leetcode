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
        if (numRows == 1)
            return res;
        res.add(new ArrayList<>() {
            {
                add(1);
                add(1);
            }
        });
        if (numRows == 2)
            return res;


        
        List<Integer> preRow = res.get(1);
        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>() {
                {
                    add(1);
                }
            };
            for (int j = 1; j < i - 1; j++) {
                list.add(preRow.get(j) + preRow.get(j - 1));
            }
            list.add(1);
            preRow = list;
            res.add(list);
        }
        return res;
    }
}
// @lc code=end
