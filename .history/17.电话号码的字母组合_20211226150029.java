import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
// class Solution {
//     public List<String> letterCombinations(String digits) {
//         List<String> res = new ArrayList<>();
//         String[] num = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
//         if (digits.length() == 0)
//             return res;
//         else if (digits.length() == 1) {
//             int n = Integer.valueOf(digits);
//             int len = num[n].length();
//             for (int i = 0; i < len; i++) {
//                 res.add(String.valueOf(num[n].charAt(i)));
//             }
//             System.out.println(res.toString());
//             return res;
//         } else {
//             List<String> path = new ArrayList<>();
//             int n = digits.length();
//             int[] digit = new int[n];// 存放数字
//             for (int i = 0; i < n; i++) {
//                 digit[i] = digits.charAt(i) - '0';
//             }
//             backtrack(res, path, num, digit, 0);
//         }

//         return res;
//     }

//     private void backtrack(List<String> res, List<String> path, String[] num, int[] digit, int start) {
//         if (path.size() == digit.length) {
//             String str = "";
//             for (String i : path) {
//                 str += i;
//             }
//             res.add(str);
//         } else {
//             for (int j = 0; j < num[digit[start]].length(); j++) {
//                 path.add(String.valueOf(num[digit[start]].charAt(j)));
//                 backtrack(res, path, num, digit, start + 1);
//                 path.remove(path.size() - 1);
//             }

//         }
//     }
// }
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
// @lc code=end
