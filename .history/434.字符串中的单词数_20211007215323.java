/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        if (s.length()==0) {
            return 0;
        }
        String[] n = s.split(" ");

        return n.length;

    }
}
// @lc code=end

