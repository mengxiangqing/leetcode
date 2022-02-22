/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, 0, 0, 0);

    }
    public boolean dfs(String num,int index,int count,long prevprev,long prev) {
        if (index >= num.length())
            return count > 2;
        long cur = 0;
        for (int i = index; i < num.length(); i++) {
            char c = num.charAt(i);

            if (num.charAt(index) == '0' && i > index)
                return false;

            cur = cur * 10 + c - '0';
            if (count >= 2) {
                long sum = prev + prevprev;
                if (cur > sum)
                    return false;
                if (cur < sum)
                    continue;

            }
            if (dfs(num, i + 1, count + 1, prevprev, prev)) {
                return true;
            }
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
