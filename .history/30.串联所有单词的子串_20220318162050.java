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
            hashMap.put(words[i], i + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            boolean[] isUsed = new boolean[words.length + 1];
            int count = 0;
            int start = i;
            for (int j = i + 1; j < start + maxLenth + 1 && j < s.length(); j++) {
                String str = s.substring(start, j);
                if (hashMap.get(str) != null && isUsed[hashMap.get(str)] == false) {
                    isUsed[hashMap.get(str)] = true;
                    count += 1;
                    start = j;

                    // 找到一个
                    if (count == wordsLength) {
                        res.add(i);
                    }

                }

            }
        }
        return res;
    }
}
// @lc code=end
