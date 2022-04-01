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
        int max = 0;
        for (int i = 0; i < n; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = i; j < n; j++) {
                if (list.contains(s.charAt(j))) {
                    max = Math.max(list.size(), max);
                    break;
                } else {
                    list.add(s.charAt(j));
                }
            }
            max = Math.max(list.size(), max);
        }
        return max;
    }
}
// @lc code=end
