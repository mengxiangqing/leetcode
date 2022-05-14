/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        char jin = '0';

        int lenA = a.length();
        int lenB = b.length();
        StringBuilder sBuilder = new StringBuilder();
        int i = lenA - 1, j = lenB - 1;
        char temp = '0';
        for (; i >= 0 || j >= 0; i--, j--) {
            char at = i >= 0 ? a.charAt(i) : '0';
            char bt = j >= 0 ? b.charAt(j) : '0';

            // 计算1的个数
            int count1 = count1(at, bt, jin);
            if (count1 == 1) {// 只有进位上来的1
                temp = '1';
                jin = '0';
            } else if (count1 == 2) {
                temp = '0';
                jin = '1';
            } else if (count1 == 3) {
                temp = '1';
                jin = '1';
            } else {
                temp = '0';
                jin = '0';
            }

            sBuilder.append(temp);
        }
        if (jin == '1')
            sBuilder.append(jin);

        return sBuilder.reverse().toString();
    }

    // 计算1的个数
    public int count1(char a, char b, char c) {
        int count = 0;
        if (a == '1')
            count++;
        if (b == '1')
            count++;
        if (c == '1')
            count++;
        return count;
    }
}
// @lc code=end
