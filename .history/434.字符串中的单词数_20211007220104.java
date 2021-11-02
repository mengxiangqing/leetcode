/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public static int countSegments(String s) {
        int num=0;
        if (s.length() == 0) {
            return 0;
        }
        String[] n = s.split(" ");
        for (int i = 0; i < n.length; i++) {
            if (" ".equals(n[i])) {
                num++;
            }
        }

        return n.length-num;

    }
}
// @lc code=end

