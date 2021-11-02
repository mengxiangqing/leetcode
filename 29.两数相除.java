/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
// 最小的负数是-2^31,将其转化为正数是2^31，导致溢出。因此将正数转化为负数不会导致溢出
class Solution {
    public int divide(int dividend, int divisor) {
        //溢出
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        //两个负数的除法
        int result = divideCore(dividend, divisor);
        //根据负号对商进行符号的修改
        return negative == 1 ? -result : result;
    }
    private int divideCore(int dividend,int divisor)
    {
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= 0xc0000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }
}
// @lc code=end

