/*
 * @lc app=leetcode.cn id=165 lang=cpp
 *
 * [165] 比较版本号
 */

#include <iostream>
#include <string>
#include <vector>
#include <sstream>
using namespace std;

// @lc code=start
class Solution
{
public:
    int compareVersion(string version1, string version2)
    {
        vector<string> v1str;
        vector<string> v2str;
        Stringsplit(version1, '.', v1str);
        Stringsplit(version2, '.', v2str);
        int i1 = 0;
        int i2 = 0;
        // version1 = "1.0.2", version2 = "1.0.0"
        while (i1 < v1str.size() || i2 < v2str.size())
        {
            string s1 = i1 < v1str.size() ? v1str[i1] : "0";
            string s2 = i2 < v2str.size() ? v2str[i2] : "0";
            int num1 = stoi(s1);
            int num2 = stoi(s2);
            if (num1 < num2)
            {
                return -1;
            }
            else if (num1 == num2)
            {
                i1++;
                i2++;
                if (i1 > v1str.size() && i2 > v2str.size())
                    return 0;
            }
            else
            {
                return 1;
            }
        }
        return 0;
    }

    /**
     * @brief 分割字符串
     *
     * @param str 待分割字符串
     * @param split 分隔符
     * @param res 返回结果
     */
    void Stringsplit(string str, char split, vector<string> &res)
    {
        istringstream iss(str); //输入流
        string token;
        while (getline(iss, token, split))
        {
            /* code */
            res.push_back(token);
        }
    }
};
// @lc code=end
