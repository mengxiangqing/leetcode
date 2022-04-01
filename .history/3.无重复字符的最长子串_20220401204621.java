import java.util.HashSet;
import java.util.Set;

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
        Set<Character> set = new HashSet<>();
        int max = 0;
        int right = -1;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i-1));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            max = Math.max(max, right+1-i);

        }
        return max;
    }
}
// @lc code=end
