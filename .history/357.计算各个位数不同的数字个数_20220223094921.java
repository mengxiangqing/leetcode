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
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        if (n == 2)
            return 91;
        //第几位了
        int index = 1;
        List<StringBuilder> res = new ArrayList<>();
        //加入0-9
        for (int i = 0; i < 10; i++) {
            StringBuilder num = new StringBuilder(i);
            res.add(num);
        }
        return backTracing(res,n,index);
        
    }
    //每层加一位数，最终是n位数字，以0开头的只有0
    private int backTracing(List<StringBuilder> res, int n, int index) {
        if (index >= n) {

        }
        for (int i = 0; i < 10; i++) {
            
        }
        return 0;
    }

}
// @lc code=end
