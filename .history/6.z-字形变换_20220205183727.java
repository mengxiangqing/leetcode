/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder[] sb = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        // 0 1 2 3 2 1 0 1 2 3
        int flag = 0;
        boolean isAdd = false;
        for (int i = 0; i < s.length(); i++) {
            sb[flag].append(s.charAt(i));
            if (flag == 0 || flag == numRows - 1)
                isAdd = !isAdd;
            flag += isAdd ? 1 : -1;// 太妙了
        }
        String res = "";
        for (int i = 0; i < sb.length; i++) {
            res += sb[i].toString();
        }
        return res;
    }
}
// @lc code=end
