/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        //0123210123
        for (int i = 0; i < sb.length; i++) {
            sb[i / 4].append(s.charAt(i));
        }
        String res = "";
        for (int i = 0; i < numRows; i++) {
            res += sb[i].toString();
        }
        return res;
    }
}
// @lc code=end
