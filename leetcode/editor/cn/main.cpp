//
// Created by 蒙西昂请 on 2022/5/25.
//
#include <iostream>
#include <string>
using namespace std;
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
int main(){
    Solution s;
    s.findSubstringInWraproundString("zab");
}