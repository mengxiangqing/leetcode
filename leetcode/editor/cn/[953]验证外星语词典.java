package leetcode.leetcode.editor.cn;////某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
////
//// 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 
////false。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
////输出：true
////解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。 
////
//// 示例 2： 
////
//// 
////输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
////输出：false
////解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。 
////
//// 示例 3： 
////
//// 
////输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
////输出：false
////解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 
//'∅
////' 是空白字符，定义为比任何其他字符都小（更多信息）。
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= words.length <= 100 
//// 1 <= words[i].length <= 20 
//// order.length == 26 
//// 在 words[i] 和 order 中的所有字符都是英文小写字母。 
//// 
//// Related Topics 数组 哈希表 字符串 👍 172 👎 0
//


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>(order.length()+1);
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        map.put(' ', -1);
        String[] wordsCopy = new String[words.length];
        System.arraycopy(words, 0, wordsCopy, 0, words.length);
        Arrays.sort(wordsCopy, (o1, o2) -> {
            int o1Length = o1.length();
            int o2Length = o2.length();
            for (int i = 0; i < o1Length || i < o2Length; i++) {
                char o1c = i < o1Length ? o1.charAt(i) : ' ';
                char o2c = i < o2Length ? o2.charAt(i) : ' ';
                if (map.get(o1c) < map.get(o2c)) {
                    return -1;
                } else if (map.get(o1c).equals(map.get(o2c))) {
                    continue;
                } else {
                    return 1;
                }
            }
            return 0;
        });
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(wordsCopy[i])) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
