import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solutio {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        int wordsLength = 0;// 单词总长度
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            maxLength = Math.max(maxLength, words[i].length());
            minLength = Math.min(minLength, words[i].length());
            wordsLength += words[i].length();
            hashMap.put(words[i], hashMap.getOrDefault(words[i], 0) + 1);
        }

        for (int i = 0; i + wordsLength < s.length(); i++) {
            String str = s.substring(i, i + wordsLength);
            HashMap<String, Integer> newHashMap = new HashMap<>();
            //扫描str中长度在min和max之间的子串
            label1:
            for (int j = minLength; j <= maxLength; j++) {
                for (int k = 0; k + j <= str.length(); k += j) {
                    //长度为j的子串
                    String tmpStr = str.substring(k, j + k);
                    newHashMap.put(tmpStr, newHashMap.getOrDefault(tmpStr, 0) + 1);
                    if (hashMap.get(tmpStr) != null) {
                        //剪枝，当前str已经不符合条件
                        if (newHashMap.get(tmpStr) > hashMap.get(tmpStr))
                            break label1;
                    }
                }
            }

            //foreach遍历
            Set<String> keySet = hashMap.keySet();
            int count = 0;
            for (String key : keySet) {
                if (newHashMap.get(key)!=null&&newHashMap.get(key) == hashMap.get(key)) {
                    count++;
                } else
                    break;
            }
            if (count == words.length)
                res.add(i);


        }
        return res;
    }
}
// @lc code=end
