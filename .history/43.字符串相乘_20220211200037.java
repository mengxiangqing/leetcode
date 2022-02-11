/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < num1.length(); i++) {

            n1 = n1 * 10 + (num1.charAt(i) - '0');
        }
        for (int j = 0; j < num2.length(); j++) {

            n2 = n2 * 10 + (num2.charAt(j) - '0');
        }
        int count = n1 * n2;
        return String.valueOf(count);
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
