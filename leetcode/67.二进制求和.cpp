/*
 * @lc app=leetcode.cn id=67 lang=cpp
 *
 * [67] 二进制求和
 */
#include <iostream>
#include <string>
using namespace std;
// @lc code=start
class Solution
{
public:
    string addBinary(string a, string b)
    {
        int alen = a.length()-1;
        int blen = b.length()-1;
        bool hasNext = false;
        string res = "";

        while (alen >= 0 || blen >= 0)
        {
            // cout << alen << " " << blen << endl;
            char ac = alen >= 0 ? a.at(alen) : ' ';
            char bc = blen >= 0 ? b.at(blen) : ' ';
            //如果有进位
            int c = count(ac, bc, hasNext);
            if (c == 0)
            {
                res.append("0");
                hasNext = false;
            }
            else if (c == 1)
            {
                res.append("1");
                hasNext = false;
            }
            else if (c == 2)
            {
                res.append("0");
                hasNext = true;
            }
            else if (c == 3)
            {
                res.append("1");
                hasNext = true;
            }

            alen--;
            blen--;
        }
        if (hasNext)
        {
            res.append("1");
            hasNext = false;
        }
        reverse(res.begin(), res.end());
        return res;
    }
    int count(char a, char b, bool flag)
    {
        int count = 0;
        if (a == '1')
            count++;
        if (b == '1')
            count++;
        if (flag)
            count++;
        return count;
    }
};
// @lc code=end
