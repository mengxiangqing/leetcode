/*
 * @lc app=leetcode.cn id=29 lang=cpp
 *
 * [29] 两数相除
 */

#include <limits.h>
#include<iostream>
using namespace std;
// @lc code=start
class Solution
{
public:
    int divide(int a, int b)
    {
        if (a == INT_MIN)
        {
            if (b == 1)
                return a;
            if (b == -1)
                return INT_MAX;
        }
        if (b == INT_MIN)
        {
            return a == INT_MIN ? 1 : 0;
        }
        if (a == b)
            return 1;
        if (a == 0)
            return 0;

        int res = 0;
        // true 正数，false 负数
        bool flag = true;
        // ab异号，最后一定是负数
        if ((a < 0 || b < 0) && !(a < 0 && b < 0))
        {
            flag = false;
        }
        //a b转换成负数，正数的话 -INT_MIN比INT_MAX大
        a = a < 0 ? a : -a;
        b = b < 0 ? b : -b;
        while (a <= b)
        {
            int value = b;
            int k = 1;
            // 0xc000 0000是最小值-2^31的一半
            while (value >= 0xc0000000 && a <= value + value)
            {
                value += value;
                k += k;
            }
            a -= value;
            res += k;
        }
        return flag ? res : -res;
    }
};
// @lc code=end
