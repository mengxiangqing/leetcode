import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1408 lang=java
 *
 * [1408] 数组中的字符串匹配
 */

// @lc code=start
class Solution {
    /**
     * @param words
     * @return
     */
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, new Comparator<>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }

        } );
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = words.length-1; j > i; j--) {
                if (words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }

        return res;
    }
}
// @lc code=end

