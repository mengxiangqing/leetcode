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
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int needCount = t.length();
        int size = 0;
        int minSize = Integer.MAX_VALUE;
    }

}
// @lc code=end
