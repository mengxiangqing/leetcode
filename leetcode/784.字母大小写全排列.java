import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 */

// @lc code=start
class Solution {
    public List<String> letterCasePermutation(String s) {
        int n = s.length();
        char[] ch = new char[n];
        List<Character> cs = new ArrayList<>();
        String temp = "";

        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                ch[i] = c;
            } else {
                // 都是字母
                temp += c;
            }
        }
        bachTrace(cs, res, ch, 0, temp.toLowerCase());

        return res;
    }

    private void bachTrace(List<Character> cs, List<String> res, char[] ch, int start, String temp) {
        if (cs.size() == temp.length()) {
            int i = 0;
            char[] cp = new char[ch.length];
            System.arraycopy(ch, 0, cp, 0, ch.length);
            for (int j = 0; j < cp.length; j++) {
                if (!Character.isDigit(cp[j])) {
                    cp[j] = cs.get(i++);
                }
            }
            res.add(String.valueOf(cp));
            return;
        }
        for (int i = start; i < temp.length(); i++) {
            char c = temp.charAt(i);
            cs.add(c);
            bachTrace(cs, res, ch, i + 1, temp);
            cs.remove(cs.size() - 1);
            cs.add(Character.toUpperCase(c));
            bachTrace(cs, res, ch, i + 1, temp);
            cs.remove(cs.size() - 1);
        }
    }
}
// @lc code=end
