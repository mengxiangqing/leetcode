/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int p_len = p.length();
        int s_len = s.length();
        if (p_len < s_len && !p.contains("*"))
            return false;
        int flag_s = 0;
        int flag_p = 0;
        while (flag_p < p_len && flag_s < s_len) {
            if (s.charAt(flag_s) == p.charAt(flag_p)) {
                flag_p++;
                flag_s++;
            } else if (s.charAt(flag_s) != p.charAt(flag_p)){
                if(p.charAt(flag_p) == '*') {
                    flag_s++;
                } else if (p.charAt(flag_p) == '.') {
                    flag_p++;
                    flag_s++;
                }
            }
        }
        return true;
    }
}
// @lc code=end
