import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solutio {
    public List<String> generateParenthesis(int n) {
        if (n == 1)
            return Arrays.asList("()");
        // List<String> res = new ArrayList<>();
        Set<String> hs = new HashSet<>();
        for (String s : generateParenthesis(n-1)) {
            for (int i = 0; i < 2*n-2; i++) {
                hs.add(s.substring(0, i) + "()" + s.substring(i, s.length()));
            }
        }

        return new ArrayList<>(hs);
    }
}
// @lc code=end
