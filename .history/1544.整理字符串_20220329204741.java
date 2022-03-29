/*
 * @lc app=leetcode.cn id=1544 lang=java
 *
 * [1544] 整理字符串
 */

// @lc code=start
class Solution {
    public String makeGood(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = 1;
        while (i < c.length && j < c.length) {
            if (c[i] >= 'a' & c[i] <= 'z') {
                if (c[j] >= 'A' && c[j] <= 'Z') {
                    c[j] = ' ';
                    j++;
                } else
                    continue;
            } else {
                if (c[i] >= 'a' & c[i] <= 'z')
            }
        }
        return new String(c);

    }
}
// @lc code=end
