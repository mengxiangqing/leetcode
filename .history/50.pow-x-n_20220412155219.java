/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {


    public double myPow(double x, int n) {
        if (x == (double)1)
            return x;
        int N = n >= 0 ? n : -n;
        double ans = 1;
        for (int i = 0; i < N; i++) {
            ans *= x;
        }
        return n >= 0 ? ans : 1.0 / ans;
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
