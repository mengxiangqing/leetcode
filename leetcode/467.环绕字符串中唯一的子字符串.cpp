/*
 * @lc app=leetcode.cn id=467 lang=cpp
 *
 * [467] 环绕字符串中唯一的子字符串
 */
#include <iostream>
#include <string>
using namespace std;
// @lc code=start
class Solution
{
public:
    int findSubstringInWraproundString(string p)
    {
        int count = 0;
        int i =0;
        while( i < p.length() - 1) {
            int j = i + 1;
            while (j < p.length()-1 && (p.at(j) == p.at(j - 1) + 1) || (p.at(j - 1) + 1-97) % 26 == p.at(j)-97) {
                j++;
            }
            cout<<j;
            // 子串长度
            int n = j - i;
            // 根据递增公式计算子串个数
            count += n * (n + 1) / 2;
            i = j+1;
        }
        return count;
    }
};
// @lc code=end
int main(){
    Solution s;
    s.findSubstringInWraproundString("zab");
    

}