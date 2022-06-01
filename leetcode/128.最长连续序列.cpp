/*
 * @lc app=leetcode.cn id=128 lang=cpp
 *
 * [128] 最长连续序列
 */
#include <iostream>
#include <string>
#include <vector>
#include <unordered_set>
using namespace std;
// @lc code=start
class Solution
{
public:
    int longestConsecutive(vector<int> &nums)
    {
        unordered_set<int> num_set;
        // 放进set去重
        for (auto &&num : nums)
        {
            num_set.insert(num);
        }

        int longestSize = 0;

        for (auto &&num : num_set)
        {
            if (!num_set.count(num - 1))
            {
                // 不存在num-1，也就是说重新开始计算长度
                int current_num = num;
                int current_long = 1;
                while (num_set.count(current_num + 1))
                {
                    current_num++;
                    current_long++;
                }
                longestSize = max(longestSize, current_long);
            }
        }

        return longestSize;
    }
};
// @lc code=end
