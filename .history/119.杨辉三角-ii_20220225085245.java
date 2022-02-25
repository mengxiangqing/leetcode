import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solutio {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> sum = new ArrayList<>();
        //前三行
        List<Integer> first = new ArrayList<>(Arrays.asList(1));
        if (rowIndex == 0)
            return first;
        List<Integer> second = new ArrayList<>(Arrays.asList(1,1));
        if (rowIndex == 1)
            return second;
        List<Integer> third = new ArrayList<>(Arrays.asList(1,2,1));
        if(rowIndex==2)
        sum.add(first);
        sum.add(second);
        sum.add(third);
        return first;

    }
}
// @lc code=end

