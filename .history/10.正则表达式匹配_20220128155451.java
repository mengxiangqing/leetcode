/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solutio {
    public boolean isMatch(String s, String p) {
        int p_len = p.length();
        int s_len = s.length();
        if (p_len < s_len && !p.contains("*"))
            return false;
        return true;
    }
}
// @lc code=end

