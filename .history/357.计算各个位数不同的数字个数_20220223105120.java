

/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solutio {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        if (n == 2)
            return 91;
        n = Math.min(n, 10);
        int ans=10,base =9,sum=9;
        for (int i = 1; i < n; i++) {
            ans += sum *= base--;
        }
        return ans;


    }


}
// @lc code=end
