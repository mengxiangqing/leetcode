import java.util.ArrayList;
import java.util.HashMap;
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
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (String str : words) {
            maxLenth = Math.max(str.length(), maxLenth);
            hashMap.put(str, value)
        }
        return res;
    }
}
// @lc code=end

