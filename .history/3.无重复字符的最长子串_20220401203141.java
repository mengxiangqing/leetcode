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
        int max = 0;
        Set<Character> occ = new HashSet<>();
        int rk = -1;//右指针
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                //左指针右移
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            max = Math.max(max, rk + 1 - i);

        }
        return max;
    }
}
// @lc code=end
