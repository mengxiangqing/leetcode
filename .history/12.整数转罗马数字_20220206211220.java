/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        String res = "";
        while (num>=0) {
            if (num >= 1000) {
                int count = num / 1000;
                for (int i = 0; i < count; i++) {
                    res += "M";
                }
            }
        }
        return res;
    }
}
// @lc code=end

