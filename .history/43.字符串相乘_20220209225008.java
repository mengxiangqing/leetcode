/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solutio {
    public String multiply(String num1, String num2) {
        int n1 = 0;
        int n2 = 0;
        for (int i = num1.length()-1; i >= 0;i--) {
            n1 =n1*10+ (num1.charAt(i)-'0');
        }
        for (int i = num2.length() - 1; i >= 0; i--) {
            n2 = n2 * 10 + (num2.charAt(i) - '0');
        }
        int count = n1 * n2;
        return String.valueOf(count);
    }
}
// @lc code=end

