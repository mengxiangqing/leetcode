/*
 * @lc app=leetcode.cn id=929 lang=cpp
 *
 * [929] 独特的电子邮件地址
 */
#include <vector>
#include <string>
#include <iostream>
#include <unordered_set>
using namespace std;
// @lc code=start
class Solution
{
public:
    static int numUniqueEmails(vector<string> &emails)
    {
        unordered_set<string> uniqueEmails;
        for (auto &&email : emails)
        {
            string temp = "";
            bool isYu = false;
            for (int i = 0; i < email.length(); ++i)
            {
                if (!isYu)
                {
                    if (email[i] != '.' && email[i] != '+')
                    {
                        temp += email[i];
                        if (email[i] == '@')
                            isYu = true;
                    }
                    else if (email[i] == '+')
                    {
                        while (email[i] != '@')
                        {
                            i++;
                        }
                        temp += email[i];
                        isYu = true;
                    }
                }
                else if (isYu)
                {
                    temp += email[i];
                }
            }
            uniqueEmails.insert(temp);
        }
        for (auto &&eeee : uniqueEmails)
        {
            cout << eeee << endl;
        }

        return uniqueEmails.size();
    }
};
// @lc code=end
