import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        //位数
        int index = 0;
        List<StringBuilder> res = new ArrayList<>();
        return dfs(res,n,index);
        
    }

    private int dfs(List<StringBuilder> res, int n, int index) {
        if(index>=n)
        return 0;
    }

}
// @lc code=end
