import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solutio {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int maxLenth = 0;
        int wordsLength = words.length;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            maxLenth = Math.max(maxLenth, words[i].length());
            hashMap.put(words[i], hashMap.getOrDefault(words[i], 0)+1);
        }

        for (int i = 0; i < s.length(); i++) {

        }
        return res;
    }
}
// @lc code=end
