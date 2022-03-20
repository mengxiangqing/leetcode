import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hashmap = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            List<String> list = hashmap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            hashmap.put(key, list);

        }
        return new ArrayList<>(hashmap.values());

    }
}
// @lc code=end

