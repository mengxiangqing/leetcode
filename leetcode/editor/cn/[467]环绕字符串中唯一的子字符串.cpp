//把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的： 
//
// 
// "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
// 
//
// 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
//
// 
//
// 示例 1: 
//
// 
//输入: p = "a"
//输出: 1
//解释: 字符串 s 中只有一个"a"子字符。
// 
//
// 示例 2: 
//
// 
//输入: p = "cac"
//输出: 2
//解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
// 
//
// 示例 3: 
//
// 
//输入: p = "zab"
//输出: 6
//解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= p.length <= 10⁵ 
// p 由小写英文字母构成 
// 
// Related Topics 字符串 动态规划 👍 215 👎 0
#include<iostream>
#include<string>
#include<map>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    static hash <string> myHash;

    int findSubstringInWraproundString(string p) {
        if(p.length()==1)return 1;
        int count = 0;
        int i =0;
        while( i < p.length() - 1) {
            int j = i + 1;
            while (j < p.length() && (p.at(j) == p.at(j - 1) + 1) || (p.at(j - 1) + 1-97) % 26 == p.at(j)-97) {
                j++;
            }
            cout<<j;
            int n = j - i+1;
            count += n * (n + 1) / 2;
            i = j+1;
        }
        return count;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
int main(){

}