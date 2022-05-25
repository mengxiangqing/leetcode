/*
 * @lc app=leetcode.cn id=467 lang=cpp
 *
 * [467] 环绕字符串中唯一的子字符串
 */
#include <iostream>
#include <string>
#include <vector>
#include<numeric>
using namespace std;
// @lc code=start
class Solution
{
public:
    int findSubstringInWraproundString(string p)
    {
        // dp[i]表示以字符i结尾，且在s中的子串的最长长度
        vector<int> dp(26);
        int k = 0;
        for (int i = 0; i < p.length(); i++)
        {
            // 字符之差为 1 或 -25
            if (i && (p[i] - p[i - 1] + 26) % 26 == 1)
            {
                ++k;
            }
            else
                k = 1;
            dp[p[i] - 'a'] = max(dp[p[i] - 'a'], k);
        }
        // 累加函数，开始，结尾，初值
        return accumulate(dp.begin(),dp.end(),0);
    }
};
// @lc code=end
