/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        return s.split(" ")[s.split(" ").length - 1].length();
    }
}
// @lc code=end

