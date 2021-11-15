/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {

     
        char[] str = word.toCharArray();
        if (str.length == 1) {
            return true;
        } else {
            // 首字母大写
            if (isBig(str[0])) {
                // 后面全是大写
                if (isBig(str[1])) {
                    for (int i = 1; i < str.length; i++) {
                        if (!isBig(str[i])) {
                            return false;
                        }
                    }
                }
                // 后面全是小写
                else {
                    for (int i = 1; i < str.length; i++) {
                        if (isBig(str[i]))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isBig(char c) {
        if (c >= 'A' && c <= 'X') {
            return true;
        } else
            return false;

    }
}
// @lc code=end
