/*
 * @lc app=leetcode.cn id=777 lang=java
 *
 * [777] 在LR字符串中交换相邻字符
 */

// @lc code=start
class Solution {
    public boolean canTransform(String start, String end) {
        int L = 0, R = 0, X = 0;
        for (int i = 0; i < start.length(); i++) {
            switch (start.charAt(i)) {
                case 'L':
                    L++;
                    break;
                case 'R':
                    R++;
                    break;
                case 'X':
                    X++;
                    break;
            }
        }
        for (int i = 0; i < end.length(); i++) {
            switch (end.charAt(i)) {
                case 'L':
                    L--;
                    break;
                case 'R':
                    R--;
                    break;
                case 'X':
                    X--;
                    break;
            }
        }
        // 两个字符串的个数不一样，直接返回
        if (L != 0 || R != 0 || X != 0) {
            return false;
        }

        



        return false;
    }
}
// @lc code=end
