import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1)
            return n;
        List<Character> list = new ArrayList<>();
        int max = 0;
        int right = -1;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                list.remove(0);
            }
            while (right + 1 < n && !list.contains(s.charAt(right + 1))) {
                list.add(s.charAt(right + 1));
                right++;
            }
            max = Math.max(max, list.size());

        }
        return max;
    }
}
// @lc code=end
