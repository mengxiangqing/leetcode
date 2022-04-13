/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {

    public double myPow(double x, int n) {
        // Java 代码中 int32 变量n∈[−2147483648,2147483647] ，因此当 n = -2147483648 时执行 n = -n
        // 会因越界而赋值出错。解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
        long b = n;
        double ans = 1;
        while (b > 0) {
            if ((b & 1) ==1) {
res * = x;
            }
        }
        return ans;
    }

    public double myPow1(double x, int n) {
        Long N = (long) n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, Long N) {
        double ans = 1.0;
        // 贡献的初始值为x
        double x_contribute = x;

        while (N > 0) {
            if (N % 2 == 1)
                ans *= x_contribute;
            x_contribute *= x_contribute;
            N /= 2;
        }
        return ans;
    }
}
// @lc code=end
