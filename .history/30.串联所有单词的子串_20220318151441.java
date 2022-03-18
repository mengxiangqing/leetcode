import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int maxLenth = 0;

        for (String str : words) {
            maxLenth = Math.max(str.length(), maxLenth);

        }
        return res;
    }
}
// @lc code=end

