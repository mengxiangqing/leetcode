import java.util.HashMap;
import java.util.Map;

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
        int tmp = 0;
        Map<Character, Integer> dic = new HashMap<>();
        for (int j = 0; j < n; j++) {
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            max = Math.max(max, tmp);
        }
        return max;
    }
}
// @lc code=end
