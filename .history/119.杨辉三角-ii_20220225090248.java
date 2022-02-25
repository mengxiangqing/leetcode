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
        List<List<Integer>> sum = new ArrayList<>();
        // 前三行
        List<Integer> first = new ArrayList<>(Arrays.asList(1));
        if (rowIndex == 0)
            return first;
        List<Integer> second = new ArrayList<>(Arrays.asList(1, 1));
        if (rowIndex == 1)
            return second;
        List<Integer> third = new ArrayList<>(Arrays.asList(1, 2, 1));
        if (rowIndex == 2)
            return third;
        sum.add(first);
        sum.add(second);
        sum.add(third);
        int curIndex = 2;
        while (curIndex <= rowIndex) {
            List<Integer> newNode = new ArrayList<>();
            newNode.add(1);
            for (int i = 0; i < sum.get(curIndex).size() - 1; i++) {
                newNode.add(sum.get(curIndex).get(i) + sum.get(curIndex).get(i + 1));
            }
            newNode.add(1);
            curIndex++;
            sum.add(newNode);
        }
        return sum.get(rowIndex);

    }
}
// @lc code=end
