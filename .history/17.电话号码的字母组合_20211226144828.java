import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solutio {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] num = new String[10];
        num[2] = "abc";
        num[3] = "def";
        num[4] = "ghi";
        num[5] = "jkl";
        num[6] = "mno";
        num[7] = "pqrs";
        num[8] = "tuv";
        num[9] = "wxyz";
        if (digits.length() == 0)
            return res;
        else if (digits.length() == 1) {
            int n = Integer.valueOf(digits);
            int len = num[n].length();
            for (int i = 0; i < len; i++) {
                res.add(String.valueOf(num[n].charAt(i)));
            }
            System.out.println(res.toString());
            return res;
        } else {
            List<String> path = new ArrayList<>();
            int n = digits.length();
            int[] digit = new int[n];// 存放数字
            for (int i = 0; i < n; i++) {
                digit[i] = digits.charAt(i) - '0';
            }
            backtrack(res, path, num, digit, 0);
        }

        return res;
    }

    private void backtrack(List<String> res, List<String> path, String[] num, int[] digit, int start) {
        if (path.size() == digit.length) {
            String str = "";
            for (String i : path) {
                str += i;
            }
            res.add(str);
        } else {
            for (int i = start; i < digit.length; i++) {
                for (int j = 0; j < num[digit[i]].length(); j++) {
                    path.add(String.valueOf(num[digit[i]].charAt(j)));
                    backtrack(res, path, num, digit, i + 1);
                    path.remove(path.size() - 1);
                }

            }
        }
    }
}
// @lc code=end
