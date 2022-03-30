import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() < s.length())
            return "";
        if (s.length() == t.length()) {
            return s.equals(t) ? s : "";
        }

        List<Character> res = new ArrayList<>();

        int s_len = s.length();
        int t_len = t.length();

    }
    public boolean isSub(String s)


}
// @lc code=end

