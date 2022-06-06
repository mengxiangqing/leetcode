/*
 * @lc app=leetcode.cn id=732 lang=cpp
 *
 * [732] 我的日程安排表 III
 */
#include <vector>
#include <iostream>
#include <unordered_map>
#include <map>
using namespace std;
// @lc code=start
class MyCalendarThree
{
public:
    MyCalendarThree()
    {
    }

    int book(int start, int end)
    {
        int ans = 0;
        int maxBook = 0;
        cnt[start]++; //表示从start开始预定的数目加一
        cnt[end]--;   //表示从end开始预定的数目减一
        for (auto &&[_, freq] : cnt)
        {
            maxBook += freq;
            ans = max(ans, maxBook);
        }

        return ans;
    }

private:
    map<int, int> cnt;
};

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree* obj = new MyCalendarThree();
 * int param_1 = obj->book(start,end);
 */
// @lc code=end
