

/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        //数学思路
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        if (n == 2)
            return 91;
        n = Math.min(n, 10);
        // 最高位选择有9种，第二位有9种，第三位有八种
        int ans=10,base =9,sum=9;
        for (int i = 1; i < n; i++) {
            ans += sum *= base--;
        }
        return ans;


    }


}
// @lc code=end
