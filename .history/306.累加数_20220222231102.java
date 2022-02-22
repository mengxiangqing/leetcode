import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    String Num;
    int n;
    List<List<Integer>> list = new ArrayList<>();

    public boolean isAdditiveNumber(String num) {
        Num = num;
        n = Num.length();
        return dfs(0);

    }

    private boolean dfs(int u) {
        int m = list.size();
        if (u == n)
            return m >= 3;
        int max = Num.charAt(u) == '0' ? u + 1 : n;
        List<Integer> cur = new ArrayList<>();
        for (int i = u; i < max; i++) {
            cur.add(0, Num.charAt(i) - '0');
            if(m<2||)

        }

        return false;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            sb.append(sum);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();

    }
}
// @lc code=end
