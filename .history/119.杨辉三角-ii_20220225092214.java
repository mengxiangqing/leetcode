import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {

        // 前三行
        List<Integer> pre = new ArrayList<>(Arrays.asList(1));
        if (rowIndex == 0)
            return pre;
        List<Integer> cur = new ArrayList<>(Arrays.asList(1, 1));
        if (rowIndex == 1)
            return cur;
        

        int curIndex = 1;
        while (curIndex++ <= rowIndex) {

           
        }
        return pre;

    }
}
// @lc code=end
